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

* **user_agent** : This agent uses the **server_artifact** lock (i.e **guard**) whenever it focuses on it and try to get any kind of update in order not to let any other agent to access the data at the same time and have conflicts, and it also have a set of initial goals:
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
* Send Message: Whenever the user writes a message the and chooses the reciever who will be for sure a member of the community, the agent go add the new message to the mailbox of the reciever on the server.This agent reacts in weird way sometimes so it don't send a message if it had served 10 times the same task, it prints on the screen that it can't handle sending the message.

#### Agent 2 (twitter like agent) 
This agent is designed to focus on a *twitter like* artifact, using this community,the owner agent (which means the one who creates the community) can *tweet* some "content" to other users that can access this *community* through joining it by their *assistant agents*.
When this agent receives a message from the user-agent to achieve a goal, he creates the new *twitter artifact*, focus on it and starts percepting new goals.
* Updatig the artifact members:  after creating a new artifact, an update is executed by the agent on loop to get the new members of this community from the Server and update the member's list existing in the *mail artifact*.
* Update tweets : every user has a Tweets list stored in the *Server Artifact*, and the agent uses this list to keep be updated on tweets received from the owner agent; the agent interact with the server after every period of time, get the tweets and updates the twitter interface.(similarely to the agent mail interactions, all communication in this case have to go through the server artifact). 
* Sending a tweet:  when the twitter user writes a tweet and click on the button *tweet*, the agent add this tweet on the tweets list (*on server*) associated to the agents that are focuced on the twitter artifact which means the assisatnt agents for the users that joined this community. 


#### Agent 3

This agent is designed to assist users to join and work with the forum community. He can create a Forum community by giving a name, and join with existing community by selecting a forum community name. This agent assists users to start, read and comment on forums in the forum community. 
	
**What this agent can do:**

*Create Forum:* This functionality is supposed to create forum for any user who joined with the system. Joined member can create a forum by giving a topic. 
	
*Comment on Forum:* Any user who joined with the community is supposed to add comments to the posts if he has some information to share. 

**How this agent works:**
1. Join to the workspace
2. Listen 
3. Join to server workspace
4. Search for Server artifact
5. Update its members and content time to time
6. When receive a create forum signal from user agent, make artifact to forum community
7. Focus on the artifact
8. Get signal to update servers forum list when member update or start a forum 
   
### iv.Artifacts Specification
#### MailBox Artifact
This artifact is designed to support the user with an interface as in the figure below, also it has some internal and external operations for the sake of the agent focusing on it.Whenever this artifact is created by the agent responsible for messaging, the agent as mentioned before start getting updates about the *members* from the server and uses an operation to update the combo_box provided to the user to select a reciever from. More than that whenever the user clicks a button to send the message, we have an internal operation linked to that button which signals the agent to send the message to the server.Also there is an operation provided to the agent to update the mailbox on the interface which add the new recieved messages to the text_area.

![alt text](https://github.com/AlyHdr/Multi-Agent-Project-2019/blob/master/mail_box.PNG )
In this picture the user joined the community that he created and sent himself a message and that is possible in our design.
#### Twitter Like Artifact
This artifact is dedicated to provide facility to share tweets between users using twiter like community.  The User who creates the community is it's *Owner*. Initiator can broadcast tweets and other joined members can see and reacts on owner's tweets (like) . Community_2 artifact of the system is responsible to manage *twitter like* tasks. When a client joins to the community, artifact will display twitter like user interface to that client. This artifact is supposed to provide sendTweets and updateTweets services.

*SendTweets:* Community owner can broadcast tweets. This is an internal command which supports take user entered tweets and send it to the conected server,after that agent will use an update operation to update the twitter list and displays it on the interface of the user who is joining this Twitter community. 

*UpdateTwitter:* this operation is supposed to update global tweets list the server. It updates tweets list according to clients interaction. 


![alt text](https://github.com/AlyHdr/Multi-Agent-Project-2019/blob/master/agnttwitter.PNG)

#### Forum Artifact
Forum artifact provides platform to users to share information using forum community. User who create the community can define it's topic. Initiator can start a new forum in the community and other members can add more comments to the post. Community_3 artifact is responsible to manage forum related tasks. when someone joins to the community, artifact will locate forum user interface to that client. This artifact is supposed to provide startForum and updateForum services.

*StartForum:* Community members can start new forum. After filling topic and post content user can press the publish button. It signals the agent to start new forum. Agent will excutethat command as explaine in agent description. 
	
*UpdateForum:* when members update forums, these information should be updated server in real time. this function is supposed to do that real time updating

User interface to use forum artifact

![alt text](https://github.com/AlyHdr/Multi-Agent-Project-2019/blob/master/forum.png)

## 3. How to Use *Agents & Services in the city* 
* Clone the repository
* Change Server and Clinets **IP addresses** compatible with your environment
* Run *server.jcm* under JaCaMO to run server
* Run *client.jcm* under JaCaMo to run client assistants
* Create Communities by giving a name and selecting a community type from the dropdown
* Join, Leave from existing communities
* Remove communities
* After joining, Create each community types by following the flow


## 4. Conclusion

In general this project was a good experience to go through the programming of agents and environment in multi agent programming and this project could be extended and improved in the future, we could imagine a lot of agents that have different behavoirs regarding the community that they are in.Also this architecture could be applied on a mobile phone by an application or a special device to really accomplish the goal of a smart city.This is a start point and it could lead to enormous innovations in the future.
