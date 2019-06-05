function fn() {    
   var env = karate.env; // get system property 'karate.env'
   if (!env) {
      env = 'dev';
   }
   karate.log('karate.env system property was:', env);

   var config = {
	 baseUrl: 'http://localhost:8080'
   }
   karate.log('baseUrl property is:', config.baseUrl);

   if (env == 'dev') {
      var Factory = Java.type('MockSpringMvcServlet');
      karate.configure('httpClientInstance', Factory.getMock());

   } else if (env == 'stg') {
      // customize
   } else if (env == 'prod') {
      // customize
   }

   return config;
}