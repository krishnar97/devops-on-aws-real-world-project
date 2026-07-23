# DevOps on AWS: Real-World End-to-End Project

A hands-on Udemy course that takes you from zero to a full production-style DevOps
workflow on AWS, deploying the **BookNova** microservices application on EKS.

> Based on the Istio BookInfo sample application (Apache License 2.0).

## What you'll build
An end-to-end DevOps pipeline on AWS: containerize a polyglot microservices app,
provision EKS with Terraform, deploy to Kubernetes, automate with CI/CD, add a
service mesh (Istio) with observability, autoscaling, a custom domain with TLS,
secrets management with Vault, and GitOps with ArgoCD.

## Course sections
| # | Section | Topic |
|---|---------|-------|
| S0 | Intro & Overview | Course promo, what you'll build, prerequisites |
| S1 | AWS Account & Cost Setup | Account, IAM, budgets, region (ap-south-1) |
| S2 | Setup & Tools | Docker, Terraform, AWS CLI, eksctl, kubectl, Helm |
| S3 | Containerize BookNova + ECR | docker compose, build, push to ECR |
| S4 | IaC EKS with Terraform | VPC, IAM, EKS cluster, node group |
| S5 | Deploy on EKS + Databases | Secrets, deploy, MongoDB/MySQL |
| S6 | CI/CD with GitHub Actions | Build/push + deploy pipelines |
| S7 | Service Mesh & Observability | Istio, Gateway API, Kiali, Prometheus, Grafana |
| S8 | HPA Autoscaling + Monitoring/Alerts | HPA, load test, Grafana, Slack alerts |
| S9 | Custom Domain + TLS | Cloudflare, cert-manager, Let's Encrypt |
| S10 | Vault Secrets + ArgoCD GitOps | HashiCorp Vault, ArgoCD |

## Branding / config
- App name: **BookNova**
- AWS region: **ap-south-1 (Mumbai)**
- ECR repo: `prod/booknova`
- EKS cluster: `booknova-prod-eks-01`
- Terraform prefix: `booknova`

## Repo structure
```
course/
  outline/      Course + section outlines
  scripts/      Per-lecture narration scripts (Praveen Mishra style)
  labs/         Student-facing hands-on step guides
  resources/    Downloadable adapted yaml / terraform / scripts
  slides/       Architecture talking points / slide bullets
```

## License / attribution
Teaching content © the course author. The deployed application is based on the
Istio **BookInfo** sample, licensed under the Apache License 2.0.
