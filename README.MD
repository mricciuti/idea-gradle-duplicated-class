Very simple Gradle project to demonstrate issue when importing in IDEA and not using "delegate IDE build/run actions toGradle"
See https://stackoverflow.com/questions/55855714/duplicate-generated-class-gradle-output-build-vs-intellij-output-out

Steps to reproduce (using IDEA v 2019.1 )

1) checkout the project
2) import project  in IDEA  
  - use "Import" tool and select project directory
  - in "Import Project from Gradle" wizard: select options
    -- Use auto-import
    -- Use default Gradle wrapper 	
3) In project settings, check/configure options:
  - Enable "annotation processing" (Build,Execution, Deployment > Compiler > Annotation Processors)
  - Disable "Delegate IDE build/actions to Gradle"  (Build,Execution, Deployment > Build Tools > Gradle > Runner )
4) Check in "Project structure > Project settings > Modules" configuration screen: 
   => IDEA has already added by default source folder "build/generated/annotationProcessor/java/main" ( marked RED as this folder does not exist yet)
5) Launch gradle task "build" from Gradle tool window in IDEA
   => this will mark "build/generated/annotationProcessor/java/main" directory as a (generated) source directory
  
6) Build project from IDEA ( menu "Build > Rebuild project")

 ==> error occurs .. either "duplicate class" in compiliation phase, 
   or sometimes "Internal erro in the mapping processor: .. Attemp to recreate a file for type org.mri.EntityMapperImpl"