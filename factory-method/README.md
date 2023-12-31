---
title: Factory Method
category: Creational
language: en
tag:
  - Extensibility
  - Gang of Four
---

## Also known as

- Virtual Constructor

## Intent

Define an interface for creating an object, but let subclasses decide which
class to instantiate. Factory Method lets a class defer instantiation to
subclasses.

## Explanation

Real-world example

> Blacksmith manufactures weapons. Elves require Elvish weapons and orcs require
> Orcish weapons. Depending on the customer at hand the right type of blacksmith
> is summoned.

In plain words

> It provides a way to delegate the instantiation logic to child classes.

Wikipedia says

> In class-based programming, the factory method pattern is a creational pattern
> that uses factory methods to deal with the problem of creating objects without
> having to specify the exact class of the object that will be created. This is
> done by creating objects by calling a factory method — either specified in an
> interface and implemented by child classes, or implemented in a base class and
> optionally overridden by derived classes—rather than by calling a constructor.

**Programmatic Example**

Taking our blacksmith example above. First of all, we have a `Blacksmith`
interface and some implementations for it:

```kotlin
internal interface Blacksmith {
  fun manufactureWeapon(weaponType: WeaponType): Weapon
}

internal class ElfBlacksmith : Blacksmith {
  override fun manufactureWeapon(weaponType: WeaponType): Weapon =
    ELF_ARSENAL.getOrElse(weaponType) {
      throw IllegalArgumentException("Weapon type $weaponType is not supported by elf blacksmith.")
    }
}

internal class OrcBlacksmith : Blacksmith {
  override fun manufactureWeapon(weaponType: WeaponType): Weapon =
    ORC_ARSENAL.getOrElse(weaponType) {
      throw IllegalArgumentException("Weapon type $weaponType is not supported by the orc blacksmith.")
    }
}
```

When the customers come, the correct type of blacksmith is summoned and
requested weapons are manufactured:

```kotlin
var blacksmith: Blacksmith = OrcBlacksmith()
var weapon: Weapon = blacksmith.manufactureWeapon(WeaponType.SPEAR)
logger.info("$blacksmith manufactured ${weapon.weaponType.title}")
weapon = blacksmith.manufactureWeapon(WeaponType.AXE)
logger.info("$blacksmith manufactured ${weapon.weaponType.title}")

blacksmith = ElfBlacksmith()
weapon = blacksmith.manufactureWeapon(WeaponType.SPEAR)
logger.info("$blacksmith manufactured ${weapon.weaponType.title}")
weapon = blacksmith.manufactureWeapon(WeaponType.AXE)
logger.info("$blacksmith manufactured ${weapon.weaponType.title}")
```

Program output:
```
The orc blacksmith manufactured spear
The orc blacksmith manufactured axe
The elf blacksmith manufactured spear
The elf blacksmith manufactured axe
```

## Class diagram

![Factory Method pattern class diagram](etc/factory-method.svg "Factory Method pattern class diagram")

## Applicability

Use the Factory Method pattern when:

* Class cannot anticipate the class of objects it must create.
* Class wants its subclasses to specify the objects it creates.
* Classes delegate responsibility to one of several helper subclasses, and you
  want to localize the knowledge of which helper subclass is the delegate.

## Credits

* [Design Patterns: Elements of Reusable Object-Oriented Software](https://www.amazon.com/gp/product/0201633612/ref=as_li_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=0201633612&linkCode=as2&tag=javadesignpat-20&linkId=675d49790ce11db99d90bde47f1aeb59)
* [Head First Design Patterns: A Brain-Friendly Guide](https://www.amazon.com/gp/product/0596007124/ref=as_li_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=0596007124&linkCode=as2&tag=javadesignpat-20&linkId=6b8b6eea86021af6c8e3cd3fc382cb5b)
* [Refactoring to Patterns](https://www.amazon.com/gp/product/0321213351/ref=as_li_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=0321213351&linkCode=as2&tag=javadesignpat-20&linkId=2a76fcb387234bc71b1c61150b3cc3a7)
