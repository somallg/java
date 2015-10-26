# PLT.22 Caching
* Caching content helps improving the Portlet response time for users. It also help reducing the load on servers
* Portlet Spec defines an expiration based caching mechanism. This caching mechanism is per Portlet. Caching content must not be shared across different user clients displaying the same Portlet for the private cache scope
* Portlet Containers are not required to implement expiration caching. Portlet Container implementing this caching mechanism may disable it, partially or completely, at any time to free memory resources

## PLT.22.1 Expiration Cache
* Portlets that want their content to be cached using expiration should define the default duration (in seconds) of the *expiration-cache* element in the deployment descriptor
* Portlet container should treat Portlets with no default duration as always expired
* *cache-scope* define where the caching content should be shared or not
* Portlet may programmatically alter the expiration time or caching scope by setting *EXPIRATION_CACHE* or *CACHE_SCOPE* (defined in *MimeResponse*) in *RenderResponse* or *ResourceResponse* object
* Inside the Portlet, the *CacheControl* object is available via the *MimeResponse* for setting expiration time and caching scope with *setExpirationTime* or *setScope*
* Portlet should set those values before writing to the output stream as otherwise Portal/Portlet containers may ignore the values
* If the expiration property is set to:
    * 0, the returned markup fragment should be treated as always expired
    * -1, the cache does not expire
* If caching scope is set to *PRIVATE_SCOPE* (default scope), the cached data must not be shared across users
* If caching scope is set to *PUBLIC_SCOPE*, the cache data may be shared
* If the content of a Portlet is cache, the cache has not expired and the Portlet is not the target of an action or event, Portlet container should use the data from the cache
* If the content of a Portlet is cache, the cache has not expired and the Portlet is the target of an action or event, Portlet container should discard the cache and invoke the corresponding request handling methods like *processAction*, or *processEvent*
 
### PLT.22.2 Validation Cache
* As an extension of the expiration-based caching mechanism, Portlet may use validation caching
* Validation-based caching allows Portlets to return a validation token together with the markup response and expiration time
* Portlet can set the validation token on the *RenderResponse* or *ResourceResponse* via the *ETAG* property from within Servlets/JSPs or via the *CacheControl* *setEtag* method from within the Portlet
* After the content is expired, the Portlet container should send a *render* or *serveResource* request to the Portlet with the validation token
* The Portlet can validate if the cached content for the given ETag is still valid or not
* If the content is still valid the Portlet should not render any output but either set the property *USE_CACHED_CONTENT* of the *RenderResponse* or *ResourceResponse* and a new expiry time, or *setUseCachedContent* on the *CacheControl* and set new expiry time
* Portlet should set the validation token, expiry time or caching scope before writing to the output stream as otherwise Portal/Portlet containers may ignore the values
