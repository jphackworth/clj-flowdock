; Copyright (C) 2013 John. P Hackworth
;
; This Source Code Form is subject to the terms of the Mozilla Public
; License, v. 2.0. If a copy of the MPL was not distributed with this
; file, You can obtain one at http://mozilla.org/MPL/2.0/.

(ns clj-flowdock.core
  (:require [org.httpkit.client :as http])
  (:use [clojure.java.io]))

; See https://www.flowdock.com/api/chat
(defn flow-chat-url [token] (format "https://api.flowdock.com/v1/messages/chat/%s" token))

; See https://www.flowdock.com/api/team-inbox
(defn flow-inbox-url [token] (format "https://api.flowdock.com/v1/messages/team_inbox/%s" token))

(defn send-inbox
  [& {:keys [source from_address subject content from_name reply_to
    project_category tags format_type link token]
    :or {from_name "" reply_to "" project_category "" format_type "html" tags []
    link ""}}]
    (def options {:method :post 
    :content-type "application/json"
    :user-agent "clj-flowdock 0.0.1"
    :query-params {:source source
      :from_address from_address
      :subject subject
      :content content 
      :from_name from_name
      :reply_to reply_to
      :project project_category
      :format "html"
      :tags tags 
      :link link} ; not including message_id at the moment
    :insecure? false })
    @(http/post (flow-inbox-url token) options))

(defn send-chat
  [& {:keys [content external_user_name tags message_id token] 
    :or {tags [] message_id ""}}]
  (def options {:method :post 
    :content-type "application/json"
    :user-agent "clj-flowdock 0.0.1"
    :query-params {:content content 
    :external_user_name external_user_name
    :tags tags} ; not including message_id at the moment
    :insecure? false })
  @(http/post (flow-chat-url token) options))
