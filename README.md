# spring-mongo-demo

## 1. Building docker image

The application can be build in two different way.

First (1.1) is building application inside docker and then creating runtime image. This is useful for docker hub image
build.

Second way is to build application by maven (1.2) and then create docker image for runtime (1.3).

### 1.1 Building application inside docker image

The application will be fully build inside docker image and then runtime image with jar will be created

```shell
docker build -t spring-mongo-demo .
```

### 1.2 Building application locally by maven

Building application using maven wrapper

```shell
./mvn package
```

### 1.3 Building runtime only docker image

Creating docker image with jar build locally

```shell
docker build -f runtime-only.Dockerfile -t spring-mongo-demo .
```
