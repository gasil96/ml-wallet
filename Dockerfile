FROM openjdk:11
ADD target/*.jar walletapplication
ENTRYPOINT ["java", "-jar","walletapplication"]
EXPOSE 8082