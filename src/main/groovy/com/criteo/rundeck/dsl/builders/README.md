# Regarding the way the documentation is written

The Groovydoc engine has been evaluated, and two major issues were
identified preventing its usage. The sections below describe them, and
the consequence it has on the way the documentation of the builders
must be written.

## On the usage of annotations

Documentation is written using Java annotations, instead of Javadoc
style comments, on purpose.

Java annotations are used - required - to add metadata to different
elements. Most notably, the "@DelegatesTo" annotation is used to
decorate closure-typed parameters so that IDEs can add context when
writing these closures.

Alas, the official Groovydoc API do not attach annotations to the
elements of its data model, and retrieving them requires
cross-referencing said data model with the method, parameters and
annotations obtained by the Java reflect API, which after several
attemps proved very fragile.

As a consequence, using Java annotations for documentation has been
prefered.
