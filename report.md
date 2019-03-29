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
* **Assistant agents** : Also keep updates from the server to get it back to the *artifact* associated to it by the **user agent**.Never to forget its main task which is to accomplish the missions provided by the artifact and act according to the *way* it was implemented.

![alt text](https://github.com/AlyHdr/Multi-Agent-Project-2019/blob/master/arch_1.png "Architecture of the system from a global point of view")

### ii.User Control
The user control is based on two things but before going into it's details, we need to specify the specification of the problem and why this choice have been chosen. In our system a user can have many communities (i.e own many) of three different types, and also he can at any time delete one of those communities and consequently removing all the members.He can join or leave a community not only others communities but also he can join his own community and participate and act on it.For these tasks mentioned before a **user_agent** was designed to server them accompanied with the help of a **user_artifact** to show the user a nice interface of what is going on.  

* **user_agent** : This agent had a set of initial goals:
    * Look for the user_artifact and focus on it.  
    * Update the user_artifact which makes the agent go get the list of communities from the server_artifact and come update back.
    After that the agent will be listening from incoming signals from the artifact to do either of those goals:  
    * *Create community* to add the community on the server by using a **server_artifact** operation.  
    * *Delete community* to delete the community and all its members from the list of avaiblable communities using a**server_artifact** operation.  
    * *Join community* which sends to a specific agent according to the *community type* a message to make the artifact.  
* **user_artifact** : It was a GUIArtifact which provides the user with a simple interface to manage the permissions that he allowed to do regarding communities.Events of buttons of the interface where attached to the artifact as so we can handle all the events as **internal operations** within the artifact.  
Internal operations:  
   * Create community : whenever the user types the community name and chooses the community type and presses the button to create a signal is sent to the *user_agent* triggering it with the goal to create a community and accomplish what have been described above.  
   * Join/Leave/Delete community: the user chooses a community from either combo boxes and press the desired button , then the same logic happens as in create community.
![alt text](https://github.com/AlyHdr/Multi-Agent-Project-2019/blob/master/user_artifact.jpg "Figure to show the interface linked to the explanation above")
### iii.Agents Specification
#### Agent 1
This agent was designed to focus on a *mail_box* artifact inorder to accomplish the tasks to be done a community to serve messages between agents.First the agent will be listening until the user_agent sends it an achieve goal message which is to create the *mailbox_artifact* and focus on it to start percepting new goals.The agent is responsible of:
* Update Members: whenever the artifact is created an update scenario is triggered which is a repeated process done by the agent to get the new members of the community from the server and add them to the list of available members in the *mailbox_artifact*.
* Update Mailbox: each user have a mailbox in this community but all the messages are stored on the server, so that the agent have to keep also an update on the recieved messages.It contacts the server each *interval* of time and get the new messages to update the interface.(i.e no direct interaction between agents, it's like a client/server chat application).
* Send Message: Whenever the user writes a message the and chooses the reciever who will be for sure a member of the community, the agent go add the new message to the mailbox of the reciever on the server.
![alt text](https://github.com/AlyHdr/Multi-Agent-Project-2019/blob/master/mail_box.PNG )

In this picture the user joined the community that he created and sent himself a message and that is possible in our design.
#### Agent 2 (twitter like agent) 
This agent is designed to focus on a *twitter like* artifact, using this community,the owner agent (which means the one who creates the community) can *tweet* some "content" to other users that can access this *community* through joining it by their *assistant agents*.
When this agent receives a message from the user-agent to achieve a goal, he creates the new *twitter artifact*, focus on it and starts percepting new goals.
* Updatig the artifact members:  after creating a new artifact, an update is executed by the agent on loop to get the new members of this community from the Server and update the member's list existing in the *mail artifact*.
* Update tweets : every user has a Tweets list stored in the *Server Artifact*, and the agent uses this list to keep be updated on tweets received from the owner agent; the agent interact with the server after every period of time, get the tweets and updates the twitter interface.(similarely to the agent mail interactions, all communication in this case have to go through the server artifact). 
* Sending a tweet:  when the twitter user writes a tweet and click on the button *tweet*, the agent add this tweet on the tweets list (*on server*) associated the the agents that are focuced on the twitter artifact which means the assisatnt agents for the users that joined this community. 
#### Agent 3

### iv.Artifacts Specification
#### MailBox Artifact

#### Artifact 2
#### Artifact 3


## 3. Interface and Running
