package com.jsimone.controller;

import com.jsimone.entity.Name;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.jsimone.constant.UrlPath.*;

/**
 * Example Hello Controller.  Note:  If each endpoint returns the same media type
 * its cleaner to just specify a "produces - ..." on the class @RequestMapping than to
 * annotate each endpoint with the same media type.
 */
@RestController
@Api(value = "HelloController API", tags = "HelloController API")
@RequestMapping(value = "/", produces = {MediaType.TEXT_PLAIN_VALUE})
public class HelloController {

    @ApiOperation(value = "Hello World")
    @GetMapping(value = URL_HELLO1)
    public String sayHello2() {
        return "Hello World";
    }

    @ApiOperation(value = "Hello name using path variable")
    @GetMapping(value = URL_HELLO2)
    public String sayHello2(@PathVariable String name) {
        return String.format("Hello %s", name);
    }

    @ApiOperation(value = "Hello name using required URL parameter with validation constraint")
    @GetMapping(value = URL_HELLO3)
    public String sayHello3(@Valid Name name) {
        return String.format("Hello %s", name);
    }

    @ApiOperation(value = "Hello name using optional URL parameter as simple request parameter")
    @GetMapping(value = URL_HELLO4)
    public String sayHello4(@RequestParam(required = false) String name) {
        if (name == null || name.isEmpty()) {
            name = "unknown";
        }
        return String.format("Hello %s", name);
    }

}