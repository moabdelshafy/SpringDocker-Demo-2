# SpringDocker-Demo 2

A standalone Spring Boot REST API for testing Docker Hub publishing and Render deployment using Github Actions. It has no database, Redis, or other external runtime dependencies.

## API

`GET /products`

Example response:

```json
[
  {"id": 1, "name": "Laptop"},
  {"id": 2, "name": "Keyboard"},
  {"id": 3, "name": "Monitor"}
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

## GitHub Actions and Docker Hub

The workflow runs tests, builds the JAR, and publishes this image whenever code is pushed to `master`:

`shefoo/spring-docker-demo-2:latest`

Before pushing:

1. Create the public Docker Hub repository `spring-docker-demo-2`.
2. Add `DOCKER_USERNAME` and `DOCKER_TOKEN` to the GitHub repository's Actions secrets.

## Deploy on Render

Create a Render Web Service from:

`docker.io/shefoo/spring-docker-demo-2:latest`

No environment variables are required. The application automatically uses Render's `PORT` value and defaults to port `8080` everywhere else.
