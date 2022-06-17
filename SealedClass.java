package java17;

/*
In short sealed classes gives you the control of which models, classes that can implement or extend that class/interface.
*/

public sealed class SealedClass permits ClassA, ClassB{}

final class  ClassA extends SealedClass {}

non-sealed class ClassB extends SealedClass {}

//class ClassC extends  SealedClass{}