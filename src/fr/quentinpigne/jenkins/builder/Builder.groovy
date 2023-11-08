#!/usr/bin/env groovy
package fr.quentinpigne.jenkins.builder

/**
 * Common interface to build and deliver an application
 */
interface Builder extends Serializable {
  /**
    * Compile the source code
    * @param params pipeline parameters
    */
  void compile(Map<String, Object> params)

  /**
    * Lint the source code
    * @param params pipeline parameters
    */
  void lint(Map<String, Object> params)

  /**
    * Run unit tests suite
    * @param params pipeline parameters
    */
  void test(Map<String, Object> params)

  /**
    * Package the source code
    * @param params pipeline parameters
    */
  void package(Map<String, Object> params)

  /**
    * Publish the compiled source code
    * @param params pipeline parameters
    */
  void publish(Map<String, Object> params)
}
