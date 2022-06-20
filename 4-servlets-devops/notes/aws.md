# AWS: Amazon Web Services
Amazon provides many technical services available in the cloud
They follow a "pay as you go" model, which means you are only charged for the exact uptime of the services that you are leveraging.
They also have a series of services that are labelled as "free-tier", which will not cost money if used under certain limitations, such as 20 GB storage maximum, etc.
Some other services are under "free-tier" only for the first 12 months after making an AWS account.

There are MANY different services:
- EC2: Elastic Compute Cloud
    - Be careful about the name, don't mix it up
    - Cloud Server
    - Different OSes, such as linux, windows, mac, etc
    - We'll use linux
        - Often cheaper than the other choices
- EBS: Elastic Block Storage
    - Used to be its own service entirely
        - But now exists primarily under EC2s and other services
    - Isolated SSDs (Solid State Drive), that can be attached to other services
- RDS: Relational Database Service
    - We have used this already
    - Cloud database service
- ELB: Elastic Load Balancing (Balancer)
    - Control traffic to split between sources/targets evenly
    - Tie into the concept of Horizontal Scaling
        - Where we have multiple instances/servers of the same service
        - We split traffic across them evenly
        - Very important tenant of SRE is scalability
- S3: Simple Storage Service
    - Large Object Storage (up to 5000 TB+)
    - Has metadata
        - Versioning feature
    - Structured within different S3 "buckets"
    - Different from EBS
    - Can store static html files
        - Allows static webpage hostic
    - Or perhaps static images
- Route 53
    - Domain Name System (DNS) Service
    - Resolve "hostnames" as specific IP Addresses
- AMI: Amazon Machine Image
    - Blueprints for the OSes used by EC2s
    - OS: Operating System
        - Software that is used to interface between low-level hardware and user actions
    - Image
        - Blieprint for Operating System
        - Same association between Images and OSes as Classes and Objects
    - AMI's are different images to create different Operating Systems for your EC2s
        - A ton of different ones
            - Different varieties of linux, mac, and Windows
        - There are some Amazon specific varieties of Linux
- IAM: Identity & Access Management
    - Role-based permissions/security service
    - Can configure different roles
        - Admin
        - Trainers
        - QC
        - Staging
    - One high level AWS account for an entire organization
        - Individuals will have sub-users (IAM users) with corresponding roles and permissions
            to access certain kinds of services
- SG: Security Groups
    - Set of rules defining how traffic is filtered
    - What IPs are allowed to access my RDS or EC2?
    - What IPs are my RDS and EC2 allowed to response TO?
- VPC: Virtual Private Cloud
    - Private configuration for all of the services within an AWS account
    - Your own private section of the cloud

# Auto-Scaling
- The idea that we want to automatically scale the amount of resources at our disposal
- Very powerful, and helpful in Industry
- But on a personal level, could accidentally accrue a lot of cost
- Vertical vs Horizontal Scaling
    - Vertical Scaling: Increase the power of an instance/server
    - Horizontal Scaling: Increase the number of instances/servers
    - In older days, Vertical Scaling was primarily used
        - It took a lot of time to provision and configure new servers
    - In modern days, companies such as Amazon have setup really convenient ways
        to provision new servers
        - This has opened the door to Horizontal Scaling

Generally speaking, vertical scaling becomes more expensive, the higher scale you go. This becomes inefficient. Which makes Horizontal Scaling generally more efficient, money-wise.

Event small comapnies must now be prepared to scale their products globally. This of course has many challenges. But since that is where the demand is, that is where the money is.

## Cloud Models

### Software Infrastructure Components
1. Application
2. Data
3. Runtime Environment
4. Middleware
5. Operating System
6. Virtualization
7. Servers
8. Storage
9. Networking

Different Cloud Models that offer different portions of the Software Infrastructure Components
    as a Service
- Software as a Service (SaaS)
    - Provides everything from 1 - 9
    - Ex: Google Docs, Microsoft Office 365, SonarCloud
    - Consumers: End Users
- Platform as a Service (PaaS)
    - Provides everything from 3 - 9
    - Allows hosting of application/data while bypassing all of the runtime environments and middleware that is handled for you
    - Ex: AWS Elastic Beanstalk, Heroku, "Microsoft Azure App Service"
    - Consumers: Developers
- Infrastructure as a Service (IaaS)
    - Provides everything from 5 - 9
    - Ex: AWS EC2
    - Consumers: SREs, System Administrators, (Sometimes regular developers)
- Not exhaustive
    - DataBase as a Service
        - RDS ... although RDS can also be condidered PaaS
