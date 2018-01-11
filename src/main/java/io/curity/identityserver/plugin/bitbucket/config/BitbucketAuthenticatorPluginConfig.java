/*
 *  Copyright 2017 Curity AB
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package io.curity.identityserver.plugin.bitbucket.config;

import se.curity.identityserver.sdk.config.Configuration;
import se.curity.identityserver.sdk.config.annotation.DefaultBoolean;
import se.curity.identityserver.sdk.config.annotation.DefaultURI;
import se.curity.identityserver.sdk.config.annotation.Description;
import se.curity.identityserver.sdk.service.ExceptionFactory;
import se.curity.identityserver.sdk.service.HttpClient;
import se.curity.identityserver.sdk.service.Json;
import se.curity.identityserver.sdk.service.SessionManager;
import se.curity.identityserver.sdk.service.WebServiceClientFactory;
import se.curity.identityserver.sdk.service.authentication.AuthenticatorInformationProvider;

import java.net.URI;
import java.util.Optional;

@SuppressWarnings("InterfaceNeverImplemented")
public interface BitbucketAuthenticatorPluginConfig extends Configuration
{
    @Description("Consumer key")
    String getClientId();

    @Description("Consumer secret of the client application")
    String getClientSecret();

    @Description("Get list of teams the user is a member of")
    @DefaultBoolean(false)
    boolean isGetTeams();

    @Description("Get list of repositories the user has access to")
    @DefaultBoolean(false)
    boolean isGetRepositories();

    @Description("Get user account information as well as email")
    @DefaultBoolean(false)
    boolean isGetAccountInformation();

    @Description("Get the users email address")
    @DefaultBoolean(true)
    boolean isGetEmails();

    @Description("The name of the team the user must be a part of to login")
    Optional<String> getTeamName();


    @Description("The HTTP client with any proxy and TLS settings that will be used to connect to slack")
    Optional<HttpClient> getHttpClient();

    SessionManager getSessionManager();

    ExceptionFactory getExceptionFactory();

    AuthenticatorInformationProvider getAuthenticatorInformationProvider();

    WebServiceClientFactory getWebServiceClientFactory();

    Json getJson();

}
