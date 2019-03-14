// Agent agent_3 in project multi_agent_project_2019

/* Initial beliefs and rules */

!setup.
/* Initial goals */
+!setup : true
	<- 	.my_name(Me);
        .print("Hello from ",Me);
        
		joinRemoteWorkspace("city","localhost",_);
		// focus of UserArtifcat
		focusWhenAvailable("user_artifact")
		
		println("ready");
		.
		
-!setup 
	<- 	.wait(1000);
		.println("Problem in Setup");
		!setup.

+cmdPostForum(forumTopic, forumContent)
	<- 	.println("Post: Topic is ",forumTopic," with content ",forumContent).

+cmdFocus3(CommunityName)
	<- 
	focusWhenAvailable(CommunityName)
        println("ready");.

{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moiseJar/asl/org-obedient.asl") }