FROM openjdk:11-jdk-slim as builder

ENV LANG=en_US.utf8 \
    TZ=Asia/Shanghai \
    SVC_HOME=/home/featx \
    SVC_ENV=DEV

RUN set -ex &&\
    apt update && apt install git &&\
    cd $API_HOME && git clone https://featx.org/templet/spring-cloud.git &&\
    cd spring-cloud && chmod +x ./gradlew &&\
    ./gradlew build -x test

FROM openjdk:11-jre-slim

ENV LANG=en_US.utf8 \
    SVC_HOME=/home/featx \
    SVC_ENV=DEV \
    TZ=Asia/Shanghai

#   SW_AGENT_NAME=api-search \
#   SW_AGENT_COLLECTOR_BACKEND_SERVICES=172.17.0.6:11800
#   -javaagent:/mnt/local/apache.com/skywalking/agent/skywalking-agent.jar
COPY --from=builder build/libs/api-search-1.0.0.jar ${SVC_HOME}/

WORKDIR $SVC_HOME

RUN set -ex && \
  mkdir log && \
  cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
  date

EXPOSE 7071
# Remote Debug Usage: Expose the debug port to host, And add the agent JOPTS to java CMD
EXPOSE 5005
# "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005",
CMD ["java", "-Xms512m", "-Xmx512m", "-XX:MetaspaceSize=128m", "-XX:MaxMetaspaceSize=256m", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005", "-jar", "spring-cloud-0.0.1-SNAPSHOT.jar", ">", "log/spring-cloud.log"]