// Agent sample_agent in project multi_agent_project_2019

/* Initial beliefs and rules */

/* Initial goals */
!setup.
!update.
// Initialisation Plans
 
+!setup : true
	<- 	.my_name(Me);
        .print("Hello from ",Me);
		// Creation of UserArtifcat
		
		//joinWorkspace("my_communities",Id);
		
		//makeArtifact("user_artifact","multi_agent_project_2019.UserArtifact",["user_artifact"],Art_Id);
		//focus(Art_Id);
		
		//println("ready");
		.
-!setup 
	<- 	.wait(1000);
		.println("Problem in Setup");
		!setup.

+!update : true <-  
				    !setup_server(Server_Id);focus(Server_Id);
					.println("Update...");
					/*
					 * use the gaurd lock to not allow any other agent to use the data on the server artifact
					 */
					lock

					getCommunities(Communities);
					//stopFocus(Server_Id);
					
					//!setup_user(User_Id);focus(User_Id);
					//lookupArtifact("user_artifact",User_Id);
					//focus(User_Id);
					/*
					 * unlock to let others get updates also
					 */
					unlock
					
					updateCommunities(Communities);
					.wait(10000);
					!update.

-!update
	<- 	.wait(2000);
		.println("Problem in update");
		!update;
		.
+!setup_server(Server_Id) <- joinRemoteWorkspace("city","127.0.0.1",_);
		 lookupArtifact("server_artifact",Server_Id)[wsp("city")].

+!setup_user(User_Id) <- joinRemoteWorkspace("my_communities","127.0.0.1",_);
		 lookupArtifact("user_artifact",User_Id)[wsp("my_communities")].
	 
+cmd("createCommunity",CommunityName,CommunityType)
	<- 
		!setup_server(Server_Id);focus(Server_Id);
		.my_name(Me);
		
		// Add a new community to list of communities on the server
		
		addCommunity(Me,CommunityName,CommunityType);
		stopFocus(Server_Id);
		
		//!setup_user(User_Id);focus(User_Id);

		.
+cmd("joinCommunity1",CommunityName,CommunityType)
	<- 
		!setup_server(Server_Id);
		
		focus(Server_Id);
		.my_name(Me);
		
		// Join a community from the list of communities on the server
		
		joinCommunityOnServer(CommunityName,Me);
		
		.send(mailAgent,tell, create_mailbox(CommunityName,CommunityType,Me));
		//.send(agentThree, tell, create_forum(CommunityName, CommunityType, Me));
        //.send(othmane_agent, tell, create_twitter(CommunityName, CommunityType, Me));
        .
+cmd("joinCommunity2",CommunityName,CommunityType)
	<- 
		!setup_server(Server_Id);
		
		focus(Server_Id);
		.my_name(Me);
		
		// Join a community from the list of communities on the server
		
		joinCommunityOnServer(CommunityName,Me);
		
		//.send(mailAgent,tell,create_mailbox(CommunityName,CommunityType,Me));
		//.send(agentThree, tell, create_forum(CommunityName, CommunityType, Me));
        .send(othmane_agent, tell, create_twitter(CommunityName, CommunityType, Me));
        .
+cmd("joinCommunity3",CommunityName,CommunityType)
	<- 
		!setup_server(Server_Id);
		
		focus(Server_Id);
		.my_name(Me);
		
		// Join a community from the list of communities on the server
		
		joinCommunityOnServer(CommunityName,Me);
		
		//.send(mailAgent,tell,create_mailbox(CommunityName,CommunityType,Me));
		.send(agentThree, tell, create_forum(CommunityName, CommunityType, Me));
        //.send(othmane_agent, tell, create_twitter(CommunityName, CommunityType, Me));
        .
+cmd("deleteCommunity",CommunityName)
	<- 
		!setup_server(Server_Id);
		
		focus(Server_Id);
		.my_name(Me);
		
		// delete a community from the list of communities on the server
		
		deleteCommunityOnServer(CommunityName);
		
		//stopFocus(Server_Id);
		//!setup_user(User_Id);focus(User_Id);
		.
		
+cmd("leaveCommunity",CommunityName)
	<- 
		!setup_server(Server_Id);
		
		focus(Server_Id);
		.my_name(Me);
		
		// Join a community from the list of communities on the server
		
		leaveCommunityOnServer(CommunityName)
		
		//stopFocus(Server_Id);
		//!setup_user(User_Id);focus(User_Id);
		.


{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moiseJar/asl/org-obedient.asl") }
