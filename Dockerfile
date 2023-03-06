FROM amazoncorretto:19.0.2-al2 as builder

WORKDIR /tzicuri_microservices

COPY ./mvnw .
COPY ./pom.xml .
COPY ./.mvn ./.mvn

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

COPY ./src ./src

RUN ./mvnw clean package -DskipTests

FROM amazoncorretto:19.0.2-al2

WORKDIR /tzicuri_microservices

COPY --from=builder /tzicuri_microservices/target/tzicuri-microservices.jar .

EXPOSE 2312

ENTRYPOINT [ "java","-jar","tzicuri-microservices.jar" ]
