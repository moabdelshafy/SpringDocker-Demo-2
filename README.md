# SpringDocker-Demo 2

A standalone Spring Boot REST API for testing Docker Hub publishing and Render deployment using Github Actions. It has no database, Redis, or other external runtime dependencies.

## API

`GET /products`

Example response:

```json
[
  {"id": 1, "name": "Laptop"},
  {"id": 2, "name": "Keyboard"},
  {"id": 3, "name": "Monitor"},
  {"id": 4, "name": "Mouse"}
]
```

## Run Locally

```powershell
.\mvnw.cmd spring-boot:run
```

Then open:

`http://localhost:8080/products`

## Run With Docker Compose

```bash
docker compose up
```

Then open:

`http://localhost:9090/products`

## Automated CI/CD

Whenever code is pushed or merged into `master`, the GitHub Actions workflow:

1. Builds the application and runs its tests with Maven.
2. Builds and publishes `shefoo/spring-docker-demo-2:latest` to Docker Hub.
3. Calls the Render deploy hook after the new Docker image is published.

The workflow can also be started manually from the GitHub Actions page.

### Configure Docker Hub Secrets

Create the public Docker Hub repository `spring-docker-demo-2`, then add these GitHub Actions repository secrets:

- `DOCKER_USERNAME`: your Docker Hub username.
- `DOCKER_TOKEN2`: a Docker Hub access token with permission to push images.

To add each secret, go to:

```text
Repository
↓
Settings
↓
Secrets and variables
↓
Actions
↓
New repository secret
```

## Deploy on Render

Create a Render Web Service from:

`docker.io/shefoo/spring-docker-demo-2:latest`

No environment variables are required. The application automatically uses Render's `PORT` value and defaults to port `8080` everywhere else.

### Configure Automatic Render Deployment

Generate a deploy hook in Render:

```text
Dashboard
↓
Your Service
↓
Settings
↓
Deploy Hook
↓
Generate Deploy Hook
```

Copy the generated hook URL. In GitHub, go to:

```text
Repository
↓
Settings
↓
Secrets and variables
↓
Actions
↓
New repository secret
```

Create a secret named `RENDER_DEPLOY_HOOK` and paste the Render deploy-hook URL as its value. The workflow uses this secret to trigger a new Render deployment only after the latest Docker image has been successfully published.

Keep the deploy-hook URL private because anyone with the URL can trigger a deployment.
