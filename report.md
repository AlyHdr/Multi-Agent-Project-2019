# Multi-Agent-Project-2019
**Course**:Multi-Agent Object Programming.  
**Supervisor**:Pr. Olivier Boissier.  
**Members**:
* HAIDAR Ali
* RANCHA GODAGE Malshani
* BELLAGH Othmane

## 1. Introduction

The aim of the project was to design and program a multi-agent based virtual community management platform for sharing information within a smart city. The city is equipped with **community servers** situated in places or buildings of the city.
Inhabitants of such smart cities are provided with a smart device that contains a **community assistant** that acts under his/her control. They delegate to this community assistant the management of the sharing of information according to the topics that he/she is interested in and to the information he/she is ready to share with other users.
The implementation of this concept was done using the **JaCaMo** platform which is used for multi-agent based programming and we used **github** as versioning tool to work collaboratively.

## 2. System Specifications
In this section, a low level description of our system is demonstrated where each member worked on implementing one type of assistants (i.e **Agent**) and one type of community (i.e **Artifact**).And over those there was an abstract layer as user controll which used a (user_agent,UserArtifact).

### i.Global View
Our system is composed of three main parts:  
* **Community Server** : The core of the system where all the data about *(communities , members and every item related to them)* is stored. For now the server have a runtime capability to store these information in structured lists and objects.A **server artifact** have been implemented to allow the agents interact with the information stored on the server where they have permissions and operations to (edit/delete/add stufff).
* **User agent/artifact** : The user agent was designed to have a repeated update according to an *interval* time to maintain the new added members to community and update back the *user artifact*, it also serves the tasks associated by the user from the *user artifact* and accomplish these tasks.
* **Assistant agents** : Also keep updates from the server to get it back to the *artifact* associated to it by the **user agent**.Never to forget it's main task which is to accomplish the missions provided by the artifact and act according to the *way* it was implemented.

![alt text](https://github.com/AlyHdr/Multi-Agent-Project-2019/blob/master/arch_1.png =400x300 "Architecture of the system from a global point of view")

### ii.User Control
### iii.Agents Specification
#### Agent 1
#### Agent 2
#### Agent 3

### iv.Artifacts Specification
#### Artifact 1
#### Artifact 2
#### Artifact 3


## 3. Interface and Running
