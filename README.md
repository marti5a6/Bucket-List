# Bucket List

## Introduction

Bucket List is an android application for trip planning that allows the users to select interested activities and receive information about local events based on their location. The group is composed of the following members:

**Tony Martin** - *DevOps and Product Owner*

**Gabe DiCarlo** - *Integration Specialist*

**AJ Morgan** - *UI Specialist*

**Jack Otten** - *Integration/UI Specialist*

## Storyboard (Screen Mockups)

![Images of Storyboard](https://user-images.githubusercontent.com/64533297/120045723-a497f880-bfde-11eb-8f7f-3802b0b9015b.png)

You can access our Storyboard [here](https://projects.invisionapp.com/prototype/ckp7io8bz0005de01heazlgrf/play) at Invision.

## Functional Requirements

(in this format, fill in the parentheses with your own words):
As a (User)
I want (Feature)
So that I can (Do Something)

Elaborate each of these with several examples in Given When Then format:
Given (Prerequisite)
When (Series of Steps)
Then (Expected Result)

(Be very specific on Given When Thens, as they should describe test parameters. Describe a specific set of outputs for a given set of inputs. In other words, "Given that shoe polish is normally $2.89, and there is a buy one get one free offer, When the user purchases two shoe polishes, Then the final cost will be $2.89",  is much better than, "Given that the user selects an item, and the item is on sale, then the item is sold at the sale price", because it references a specific item, with specific input and output price You should have a few (2-4) requirements. The Given/When/Then syntax will form the basis of our unit tests. Consider different cases: good data, bad data, multiple sets of data, etc.

Given a current set of GPS coordinates or city/state and a keyword list, 
When user clicks button, search for matches within a 100 miles of that city/state or coordinates,
Then display matches. Keyword list may include bucket list items or other interests.

Given a hiking trail's GPS coordinates, when the user clicks search, parse through database containing trail name and coordinates, then display the matches.

Given a set of GPS coordiantes, location name, city/state information, and description, when the user searches for a Bucket-List location, parse through the database and find all matching keywords, then display results.

Given a set of GPS coordiantes, location name, city/state information, and description results for a location, when the user clicks add, parse through the database and look for matches, then add a new entry for non existent locations.

## Class Diagram

Show data classes (DTOs), Activities, Fragments, MVVM, etc. I use ArgoUML to model classes in a diagram.  Other tools work as well.

## Class Diagram Description

One or two lines for each class to describe  use of interfaces, JME classes, Dalvik (Android) classes and resources, interfaces, etc. Don't worry about putting more than a few words to each class; this does not need to be thorough.

## A Product Backlog

Product backlog items are stories.  Stories should be features, like "Take a picture and post on Facebook", not technical, like "Make the database". Each story should be a separate Project in GitHub. The title of the project should be the name of the story. As long as you have these stories listed as Projects in GitHub, I can look at your projects to see your backlog. No need to repeat it in the design document. There should be more stories than you will finish in one sprint. The Product Owner can choose from this list, which stories to complete in each sprint.

## Scrum Board

(A milestone for Sprint #1, with tasks associated.
Tasked stories for Sprint #1.

Sprint tasks that elaborate on the stories, with technical details. These should be technical tasks that are required to implement one of the features. You only need to task out stories for Sprint #1. You can task out stories for Sprint #2 and #3 as we get closer to those sprints. The Product Owner/Scrum Master/DevOps person on your team should select stories to play for each sprint, from the list of available stories in the Product Backlog. As long as you have the tasks in GitHub Projects, under Projects, and associated with milestones, you do not need to repeat them in the design doc. I'll look at the Project and Milestone view to see them.)

Our [Scrum Board](https://github.com/marti5a6/Bucket-List/projects/2) can be found in the Projects tab, alongside other stories in the product backlog.

Here is our Scrum Board after the last sprint: (picture).

## Scrum Roles

**Tony Martin** - *Product Owner, Development Team*

**Gabe DiCarlo** - *Scrum Master, Development Team*

**AJ Morgan** - *Development Team*

**Jack Otten** - *Development Team*

## Group Meetings/Communication

The group communicates via [Discord](https://discord.com). We utiluze the general text-channel for frequent discussion and decision-making, and we utilize the general voice-channel for our standup calls.

![Image of Bucket-List Discord Server](https://i.ibb.co/w7J5xXd/image.png)

