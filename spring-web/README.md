#### Table of content
- ``Model``, ``ModelMap``, ``ModelAndView``
- 

#### Note:
- Thymeleaf:
  - Include thymeleaf starter
  - Add prefix in ``application.yml``
  - Create template such as ``viewPage.html``
  - return string ``path/to/the/viewPage.html`` in controller.

- Request Flow:
![req-flow][req-flow]
- [Configure order of filter](https://stackoverflow.com/questions/25957879/filter-order-in-spring-boot)

#### To include:
- ``FilterRegistrationBean``
  - ``CharacterEncodingFilter``
- ``securityFilterChain``
- ``WebMvcConfigurer``
  - ``addArgumentResolvers``
- ``MultipartResolver``
- ``StandardServletMultipartResolver``
- 


[req-flow]: https://camo.qiitausercontent.com/7f6780f877a4739d0f7b1e4e3f68c029ea88c8dc/68747470733a2f2f71696974612d696d6167652d73746f72652e73332e616d617a6f6e6177732e636f6d2f302f3131373331332f63623963666463362d646339662d343936612d363030322d3331643133396532313338332e706e67
