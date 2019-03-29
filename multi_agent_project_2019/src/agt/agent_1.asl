// Agent agent_1 in project multi_agent_project_2019

/* Initial beliefs and rules */

nbMessages(3).

!setup.

/* Initial goals */



+!setup : true
	<- 	.my_name(Me);
        .print("Hello from ",Me);
        
		joinWorkspace("my_communities",_);
		// focus of UserArtifcat
		//focusWhenAvailable("user_artifact")
		
		println("ready");
		.
		
-!setup 
	<- 	.wait(1000);
		.println("Problem in Setup");
		!setup.
		
+!update(CommunityName,OwnerName) : true <-  
				    !setup_server(Server_Id);focus(Server_Id);
					/*
					 * use the gaurd lock to not allow any other agent to use the data on the server artifact
					 */
					lock
					getMessages(Messages,OwnerName);
					
					updateMessages(Messages);
					
					getMembers(Members,CommunityName);
					/*
					 * unlock to let others get updates also
					 */
					unlock
					updateMembers(Members);
					
					.wait(10000);
					!update(CommunityName,OwnerName).

-!update(CommunityName,OwnerName)
	<- 	.wait(2000);
		.println("Problem in update");
		!update(CommunityName).


+!setup_server(Server_Id) <- joinRemoteWorkspace("city","127.0.0.1",_);
		 lookupArtifact("server_artifact",Server_Id)[wsp("city")].	

+create_mailbox(CommunityName,CommunityType,OwnerName) : true <-
		.concat("multi_agent_project_2019.",CommunityType,Type);
		makeArtifact(CommunityName,Type,[CommunityName],Art_Id)
		focus(Art_Id);
		!update(CommunityName,OwnerName);
	 .
	 
+cmdSendMessage(MessageContent,Reciever): nbMessages(N) & N>0
	<- 	!setup_server(Server_Id);focus(Server_Id);
		.my_name(Sender);
		N1 = N - 1;
		-+nbMessages(N1);
		upMailBox(MessageContent,Sender,Reciever);
	.
+cmdSendMessage(MessageContent,Reciever):nbMessages(N) & N == 0<- .print("I will not send this message my head is full"); -+nbMessages(10).

{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moiseJar/asl/org-obedient.asl") }
