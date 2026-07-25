# S3-L13: Understand the Docker Compose File (Hands-On, Praveen Style)

**Section:** REAL PROJECT #1 — Containerization Microservices Project
**Duration:** ~7 min
**Goal:** Understand our `docker-compose.yaml` — how one file describes all four
BookNova services. We only read it here, we run it in the next lesson.
**Files:** [app/docker-compose.yaml](../app/docker-compose.yaml)

---

## Intro

"Okay guys, a Dockerfile builds **one** image. But our app has **four** services. Running
four containers by hand is painful. So we use **Docker Compose** — one file to describe
all four, and later one command to start them all."

---

## Part A — read the file

File: [app/docker-compose.yaml](../app/docker-compose.yaml)

"Open `docker-compose.yaml`. Don't worry about the size — it's the same block repeated
four times, one per service. Look at **productpage**:

- `build: context: ./productpage` → build the image from that folder's Dockerfile.
- `container_name` → a friendly name for the container.
- `environment` → the same env values we set in the Dockerfile.
- `ports: 9080:9080` → publish this port to the outside. This is our front door.
- `depends_on` → start details, ratings, reviews **before** productpage.
- `restart: always` → bring it back if it crashes.

Now **details**, **ratings**, **reviews** are the same shape. The only difference: they
use `expose` instead of `ports`. `expose` keeps the port **inside** the network — other
containers can reach it, but the outside world can't. Only productpage is public."

---

## Part B — the network

"At the bottom we define one network — `booknova-net` — and every service joins it. On
this network a service reaches another one just by its **name**. So productpage talks to
`details`, `ratings`, `reviews` by name — no IPs. Compose gives us this for free."

---

## Recap

"So:

- A **Dockerfile** builds **one** image.
- **Compose** describes **many** containers in **one** file.
- `ports` = public, `expose` = internal only.
- Services talk to each other **by name** on the shared network.

We only understand the file here. In the next lesson we clone the project from GitHub and
actually run it."
