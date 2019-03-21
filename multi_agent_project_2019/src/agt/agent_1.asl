// Agent agent_1 in project multi_agent_project_2019

/* Initial beliefs and rules */

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

					getMessages(Messages,OwnerName);
					
					updateMessages(Messages);
					
					getMembers(Members,CommunityName);
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
	 
+cmdSendMessage(MessageContent,Reciever)
	<- 	!setup_server(Server_Id);focus(Server_Id);
		.my_name(Sender);
	
		upMailBox(MessageContent,Sender,Reciever);
	.


{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moiseJar/asl/org-obedient.asl") }
