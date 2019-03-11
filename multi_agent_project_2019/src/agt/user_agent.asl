// Agent sample_agent in project multi_agent_project_2019

/* Initial beliefs and rules */

/* Initial goals */

!setup.

// Initialisation Plans
 
+!setup : true
	<- 	.my_name(Me);
        .print("Hello from ",Me);
		// Creation of UserArtifcat
		
		joinRemoteWorkspace("city","192.168.43.228",_);
		
		makeArtifact("user_artifact","multi_agent_project_2019.UserArtifact",["user_artifact"],Art_Id);
		focus(Art_Id);
		
		println("ready");
		.
		
-!setup 
	<- 	.wait(1000);
		.println("Problem in Setup");
		!setup.

+cmd("createCommunity_1",CommunityName)
	<- 	.println("Going to create community ",CommunityName," of type 1");
		
		// Creation of UserArtifcat
		makeArtifact(CommunityName,"multi_agent_project_2019.Community_1",[CommunityName],Art_Id);.

+cmd("createCommunity_2",CommunityName)
	<- 	.println("Going to create community ",CommunityName," of type 2");
	makeArtifact(CommunityName,"multi_agent_project_2019.Community_2",[CommunityName],Art_Id);.

+cmd("createCommunity_3",CommunityName)
	<- 	.println("Going to create community ",CommunityName," of type 3");
	makeArtifact(CommunityName,"multi_agent_project_2019.Community_3",[CommunityName],Art_Id);.


{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moiseJar/asl/org-obedient.asl") }
