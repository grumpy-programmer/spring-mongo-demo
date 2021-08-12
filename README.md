# spring-mongo-demo

## 1. Pre requirements

* java 11
* docker
* docker compose

## 2. Local development

Docker compose contains following services:

* mongo - the mongo database
* mongo-express - the mongo web explorer http://localhost:8081

To setup environment for local development run

```shell
docker-compose up -d
```

this will download all needed images and create containers.

To stop

```shell
docker-compose stop
```

To remove (first stop)

```shell
docker-compose rm
rm -rf volumes
```

## 3. Building gradle project

Use gradle wrapper`./gradlew` script to build the application

```shell
./gradlew build
```

## 4 Building docker image

The [Dockerfile](Dockerfile) to build docker image of the application.

For local development and testing

```shell
docker build -t spring-mongo-demo .
```

For building production docker image

```shell
docker build -t ghcr.io/grumpy-programmer/spring-mongo-demo .
```

This application is using github registry to store
images, [see more](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-container-registry)

Login to github registry

```shell
# using std input to provide password (GITHUB_TOKEN)
docker login ghcr.io -u USERNAME --password-stdin

# setting password in command line
docker login --username USERNAME --password GITHUB_TOKEN ghcr.io
```

## 5. Github actions

The build pipeline [.github/workflows/build.yml](.github/workflows/build.yml) builds gradle application, create docker
image and push the image to github registry.

Images will have shared tag latest and unique one
as `github.run_id` [see more](https://docs.github.com/en/actions/reference/context-and-expression-syntax-for-github-actions#github-context)
.

Pipeline will be triggered each time new commit will be pushed/merged to `main` branch.

For time optimization [github action cache](https://github.com/actions/cache) is added to pipeline.
