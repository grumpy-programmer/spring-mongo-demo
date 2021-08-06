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

## 3. Building docker image

The application can be build in two different way.

First (3.1) is building application inside docker and then creating runtime image. This is useful for docker hub image
build.

Second way is to build application by maven (3.2) and then create docker image for runtime (3.3).

### 3.1 Building application inside docker image

The application will be fully build inside docker image and then runtime image with jar will be created

```shell
docker build -t spring-mongo-demo .
```

### 3.2 Building application locally by maven

Building application using maven wrapper

```shell
./mvn package
```

### 3.3 Building runtime only docker image

Creating docker image with jar build locally

```shell
docker build -f runtime-only.Dockerfile -t spring-mongo-demo .
```
