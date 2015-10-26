# Replication
* Replication agents are central to AEM as the mechanism used to
	* Publish (active) content from an author to an publish environment
	* Explicitly flush content from Dispatcher cache
	* Return user input from publish environment to author environment (under control of the author environment)
* Requests are queued to the appropriate agent for processing

## Replicating from Author To Publish
* Steps
	* author requests that certain content be published (activated); this can be done by manual request, or by automatic triggers
	* request is passed to the appropriate default replication agent
	* replication agent "packages" the contnet and places it in the replication queue
	* in Websites tab the colored status indicator is set for the individual pages
	* content is lifted from the queue and transported to the publish environment using configured protocol; usually HTTP
	* a servlet in the publish environment receives the request and publishes the received content; default servlet is http://localhost:4503/bin/receive
	* multiple author and publish environment can be configured
	* ![Replication](images/1359637917097.png)
	
## Replicating from Publish To Author
* Reverse replication - return user information to the author environment, from where it is redistributed to other publish environments

## Replication - Out of the Box
* Need to Install AEM with
	* author environment on port 4502
	* publish environment on port 4503
* Replication queues
	* Default Agent (publish)
	* Reverse Replication (outbox)
	* Reverse Replication Agent (publish_reverse)
* Check the status of agent or queue in **Tools** console

## EXERCISE - Replication (Author to Publish)
1. Navigate to a page on the author environment
	* http://localhost:4502/content/geometrixx-outdoors/en/support.html
2. Edit the page to add some new text
3. **Activate Page** to publish the changes
4. Open the page on the publish instance
	* http://localhost:4503/content/geometrixx-outdoors/en/support.html
5. You can now see the changes that you entered on author

* This replication is actioned from the author instance by the
	* **Default Agent (publish)** - this agent replicates content to the default publish instance
	* http://localhost:4502/etc/replication/agents.author/publish.html
	
## EXERCISE - Reverse Replication (Publish to Author)
1. Navigate to a page on the publish environment
	* http://localhost:4503/content/geometrixx-outdoors/en/community/hiking.html
2. At the top of the page, click Sign In Or Register. Enter admin/admin to sign in
3. Below the Best GPS for Hiking topic, clock No Comments Yet
4. Enter a comment and click Post Comment
5. Open the Hiking page on the author instance and verify your comment
	* http://localhost:4502/content/geometrixx-outdoors/en/community/hiking.html
6. Open CRXDE Lite for the author instance
	* http://localhost:4502/crx/de
7. Navigate to the user generated content
	* /content/usergenerated/content/geometrixx-outdoors/en/community/hiking/journal/2012/12/best_gps_for_hiking/jcr:content/comments/1Bucket
8. Here you can see that your comment has been replicated from the publish to the author environment

* This replication is actioned from the publish environment by
	* **Reverse Replication (outbox)** - this agent stores reverse replicated content in the outbox (repo://var/replication/outbox), which acts as a queue
	* http://localhost:4503/etc/replication/agents.publish/outbox.html
	
* This agent transfers content to the author environment, by communicating with
	* **Reverse Replication Agent (publish_reverse)** - this agent polls the default publish instance to retrieve reverse replicated content from the outbox
	* http://localhost:4502/etc/replication/agents.author/publish_reverse.html
	
## Replication Agents - Out of the Box
* Default Agent
* Dispatcher Flush
* Reverse Replication
* Static Agent - store a static representation of a node into the file system