# == Before you begin make sure that your EC2 Instance Security groups accept all traffic from SSH, HTTP, and custom TCP Port 8080 ==

# 1. When you launch your instance, download your .pem key.  Drag it into a folder that's easily accessible
#    OR you could just click "EC2 Instance connect" and connect via the integrated terminal in your browser

# 2. Right click > GIt Bash into whatever directory holds your .pem key and paste the command below:
#     ssh -i mynew_key ec2-user@ec2-34-204-200-76.compute-1.amazonaws.com
# Press enter, type yes and you're in.

# /home/ec2-user is where you are (you are ec2-user)

# ====== EC2 ENVIRONMENT SETUP ======
# install cowsay and play around if you want :p
sudo yum install cowsay -y

# Set up the environment for your EC2 instance
sudo yum install java-1.8.0-openjdk-devel -y
sudo yum install maven -y
sudo yum install git -y
sudo amazon-linux-extras install tomcat8.5 -y

# Make a new directory to hold your project to host
mkdir projects
cd projects

# Clone your project into your new directory
sudo git clone <project-repo>

# Package the application into deployable WAR file
cd <project>
sudo mvn package

# Copy the WAR file to Tomcat's webapps directory to deploy
sudo cp target/YourProject.war /var/lib/tomcat/webapps/

# Start Tomcat -- by default, Tomcat will run on port 8080
sudo service tomcat start

# Congrats! Your project is now deployed and running.  You can visit it at the following address in your browser:
# http://ec2-dns.amazonaws.com:8080/YourProject/
