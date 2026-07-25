# BookNova - ratings service (Node.js)

FROM node:22-slim

WORKDIR /app

# Copy dependency manifest first (better layer caching).
COPY package.json ./

# Install dependencies (none extra here, but keeps the pattern).
RUN npm install --omit=dev

# Copy the app code.
COPY ratings.js ./

# The service listens on 9080.
EXPOSE 9080

# Run as a non-root user.
USER 1000

# Start the Node service.
CMD ["node", "ratings.js"]
