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

Given a current set of GPS coordinates or city/state and a keyword list, When user clicks button, search for matches within a 100 miles of that city/state or coordinates, Then display matches. Keyword list may include bucket list items or other interests.

Given a hiking trail's GPS coordinates, when the user clicks search, parse through database containing trail name and coordinates, then display the matches.

Given a set of GPS coordiantes, location name, city/state information, and description, when the user searches for a Bucket-List location, parse through the database and find all matching keywords, then display results.

Given a set of GPS coordiantes, location name, city/state information, and description results for a location, when the user clicks add, parse through the database and look for matches, then add a new entry for non existent locations.

## Class Diagram

![Image of Class Diagram](https://raw.githubusercontent.com/Gabe-DiCarlo/Bucket-List/main/2021-05-30-21-18-17.png)

## Class Diagram Description

Main Activity: First screen the user sees, has options to search for attractions or bucketlist items BucketListDetail: Shows details of bucketlist items RetroFitInstance: Bootstrap class required for retrofit Attraction: Noun class that represents an attraction BucketListItem: Noun class that represents a bucket list item IBucketDAO: Interface for Room to persist Bucketlist data IAttractionDAO: Interface for Retrofit to find and parse attraction JSON data.

## A Product Backlog

Our Product Backlog, or collection of stories can be found [here](https://github.com/marti5a6/Bucket-List/projects) in the Projects tab.

## Scrum Board

Our [Scrum Board](https://github.com/marti5a6/Bucket-List/projects/2) can be found in the Projects tab, alongside other stories in the product backlog.

Here is our Scrum Board after the last sprint: ![Image of Scrum Board](https://i.ibb.co/fCBjmcn/image.png)

## Scrum Roles

**Tony Martin** - *Product Owner, Development Team*

**Gabe DiCarlo** - *Scrum Master, Development Team*

**AJ Morgan** - *Development Team*

**Jack Otten** - *Development Team*

## Group Meetings/Communication

The group communicates via [Discord](https://discord.com). We utiluze the general text-channel for frequent discussion and decision-making, and we utilize the general voice-channel for our standup calls.

![Image of Bucket-List Discord Server](https://i.ibb.co/w7J5xXd/image.png)
