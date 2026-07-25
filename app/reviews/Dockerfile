# BookNova - reviews service (Java)
# Multi-stage build: compile in a JDK, run in a small JRE.

# ---- Stage 1: build ----
FROM eclipse-temurin:21-jdk AS build
WORKDIR /build
COPY Reviews.java ./
RUN javac Reviews.java

# ---- Stage 2: runtime ----
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copy only the compiled class from the build stage (small final image).
COPY --from=build /build/Reviews.class ./

# Which review version to run (v1, v2, v3).
ENV SERVICE_VERSION=v1

# The service listens on 9080.
EXPOSE 9080

# Run as a non-root user.
USER 1000

# Start the Java service.
CMD ["java", "Reviews"]
