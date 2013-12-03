# clj-flowdock

This is a library for interacting with [Flowdock](https://flowdock.com).

## Installation

Download from http://example.com/FIXME.

## Usage

TODO

### Push API

The [flowdock push api](https://www.flowdock.com/api/push) allows posting content to the Team Inbox and Chat.

#### Team Inbox

The [flowdock team inbox api](https://www.flowdock.com/api/team-inbox) lets you send mail-like messages to the team inbox of a flow.

`Required Parameters:`

- source
- from_address
- subject
- content
- token

`Optional:`

- from_name
- reply_to
- project_category
- format
- tags
- link

`Example:`

    (def my-flow-token "1234asdf89797asdfasdf")
    (send-inbox :source "App identifier" 
      :from_address "message_sender@example.com"
      :subject "My Subject"
      :content "My HTML Content"
      :from_name "John Doe"
      :reply_to "different_email@example.com" 
      :project_category "My Project" 
      :format "html"
      :tags ["tag1" "tag2"]
      :link "http://example.com"
      :token my-flow-token)


#### Chat

The [flowdock chat api](https://www.flowdock.com/api/chat) let's you post messages to a flow from an external user.

`Required Parameters:`

- content
- external_user_name
- token

`Optional:`

- tags
- message_id

`Example:`

    (def my-flow-token "1234asdf89797asdfasdf")
    (send-chat :content "Content up to a maximum of 8096 characters"
      :external_user_name "Who is sending this?"
      :tags ["some" "cool" "tags"]
      :message_id "id of message being replied to"
      :token my-flow-token)

## Rest API

Not implemented yet.

## Streaming API

Not implemented yet.

### Bugs

- No support yet for [REST API](https://www.flowdock.com/api/rest)
- No support yet for [Streaming API](https://www.flowdock.com/api/streaming)

## License

Copyright © 2013 John P. Hackworth

Distributed under the Mozilla Public License Version 2.0