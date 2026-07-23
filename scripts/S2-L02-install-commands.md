# S2-L02: Install Commands Reference

Copy-paste commands to install all DevOps tools on the Ubuntu EC2 server.
Run these in order. Assumes you are SSH'd into the Ubuntu server.

---

## 1. Docker

```sh
curl -fsSL https://get.docker.com -o install-docker.sh
sh install-docker.sh
docker version
```

Give the `ubuntu` user permission to run Docker without `sudo`:

```sh
sudo usermod -aG docker ubuntu
newgrp docker
```

---

## 2. Terraform

```sh
wget -O - https://apt.releases.hashicorp.com/gpg | sudo gpg --dearmor -o /usr/share/keyrings/hashicorp-archive-keyring.gpg
echo "deb [signed-by=/usr/share/keyrings/hashicorp-archive-keyring.gpg] https://apt.releases.hashicorp.com $(lsb_release -cs) main" | sudo tee /etc/apt/sources.list.d/hashicorp.list
sudo apt update && sudo apt install terraform -y
terraform version
```

---

## 3. AWS CLI

```sh
sudo apt install unzip -y
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
aws --version
```

---

## 4. Configure AWS Access

```sh
aws configure
```

Provide when prompted:
- AWS Access Key ID: `<your-access-key>`
- AWS Secret Access Key: `<your-secret-key>`
- Default region name: `ap-south-1`
- Default output format: `json`

Verify:

```sh
aws s3 ls
```

---

## 5. kubectl

```sh
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
kubectl version --client
```

---

## 6. Helm

```sh
curl https://raw.githubusercontent.com/helm/helm/main/scripts/get-helm-3 | bash
helm version
```
