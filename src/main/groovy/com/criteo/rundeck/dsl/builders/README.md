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

## On the dropping of parameters default values

Methods for which parameters may have default values are explicitly
duplicated on purpose.

In Java, methods having default values for parameter are compiled into
several methods having corresponding "partial" signatures. For
example, a method "foo(boolean p = false, boolean q = true)" is
compiled into one method "foo(boolean p, boolean q)", another one
"foo(boolean p) { foo(p, true); } ", and another one "foo() {
foo(false); }".

When scanning the methods of a class using the Java reflect API, these
submethods are not marked - there is no way to distinguish the full
methods from the partial ones.

As it is not desirable to show in the documentation the same method
twice, it has been prefered to do the expansion manually, and keep a
documentation annotation only on the full method.