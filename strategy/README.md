---
title: Strategy
category: Behavioral
language: en
tag:
 - Gang of Four
---

## Also known as

- Policy

## Intent

Define a family of algorithms, encapsulate each one, and make them
interchangeable. Strategy lets the algorithm vary independently of the clients
that use it.

## Explanation

Real-world example

> Slaying dragons is a dangerous job. With experience, it becomes easier.
> Veteran dragonslayers have developed different fighting strategies against
> different types of dragons.

In plain words

> Strategy pattern allows choosing the best-suited algorithm at runtime.

Wikipedia says

> In computer programming, the strategy pattern (also known as the policy
> pattern) is a behavioral software design pattern that enables selecting an
> algorithm at runtime.

**Programmatic Example**

Let's first introduce the dragon-slaying strategy interface and its
implementations.

```kotlin
fun interface DragonSlayingStrategy {
  fun execute()
}

class MeleeStrategy : DragonSlayingStrategy {
    override fun execute() {
        logger.info("With your Excalibur you sever the dragon's head!")
    }
}

class ProjectileStrategy : DragonSlayingStrategy {
  override fun execute() {
    logger.info("You shoot the dragon with the magical crossbow and it falls dead on the ground!")
  }
}

class SpellStrategy : DragonSlayingStrategy {
  override fun execute() {
    logger.info("You cast the spell of disintegration and the dragon vaporizes in a pile of dust!")
  }
}
```

And here is the mighty dragonslayer, who can pick his fighting strategy based on
the opponent.

```kotlin
class DragonSlayer(private var strategy: DragonSlayingStrategy) {
  fun changeStrategy(strategy: DragonSlayingStrategy) {
    this.strategy = strategy
  }

  fun goToBattle() {
    strategy.execute()
  }
}
```

Finally, here's the dragonslayer in action.

```kotlin
logger.info(GREEN_DRAGON_SPOTTED)
val gofDragonSlayer = DragonSlayer(MeleeStrategy())
gofDragonSlayer.goToBattle()

logger.info(RED_DRAGON_EMERGES)
gofDragonSlayer.changeStrategy(ProjectileStrategy())
gofDragonSlayer.goToBattle()

logger.info(BLACK_DRAGON_LANDS)
gofDragonSlayer.changeStrategy(SpellStrategy())
gofDragonSlayer.goToBattle()
```

Program output:

```text
Green dragon spotted ahead!
With your Excalibur you sever the dragon's head!
Red dragon emerges.
You shoot the dragon with the magical crossbow and it falls dead on the ground!
Black dragon lands before you.
You cast the spell of disintegration and the dragon vaporizes in a pile of dust!    
```

What's more, the lambda expressions in Kotlin provides another approach for the
implementation:

```kotlin
class LambdaStrategy {
  enum class Strategy(private val dragonSlayingStrategy: DragonSlayingStrategy) :
    DragonSlayingStrategy {
    MELEE_STRATEGY(
      DragonSlayingStrategy {
        logger.info("With your Excalibur you severe the dragon's head!")
      }
    ),
    PROJECTILE_STRATEGY(
      DragonSlayingStrategy {
        logger.info("You shoot the dragon with the magical crossbow and it falls dead on the ground!")
      }
    ),
    SPELL_STRATEGY(
      DragonSlayingStrategy {
        logger.info("You cast the spell of disintegration and the dragon vaporizes in a pile of dust!")
      }
    );

    override fun execute() {
      dragonSlayingStrategy.execute()
    }
  }
}
```

And here's the dragonslayer in action.

```kotlin
logger.info(GREEN_DRAGON_SPOTTED)
val enumDragonSlayer = DragonSlayer(MELEE_STRATEGY)
enumDragonSlayer.goToBattle()

logger.info(RED_DRAGON_EMERGES)
enumDragonSlayer.changeStrategy(PROJECTILE_STRATEGY)
enumDragonSlayer.goToBattle()

logger.info(BLACK_DRAGON_LANDS)
enumDragonSlayer.changeStrategy(SPELL_STRATEGY)
enumDragonSlayer.goToBattle()
```

The program output is the same as the above one.

Alternatively, a full functional approach can be used here. In such case the
`DragonSlayer` would receive lambda function to execute that would be the
strategy.

```kotlin
typealias Strategy = () -> Unit

class DragonSlayer(private var strategy: Strategy) {
    fun changeStrategy(strategy: Strategy) {
        this.strategy = strategy
    }

    fun goToBattle() {
        strategy()
    }
}
```

The strategies would be defined as functions in the scope of an `object`:

```kotlin
object Strategy {
    fun meleeStrategy() =
        logger.info("With your Excalibur you sever the dragon's head!")

    fun projectileStrategy() =
        logger.info("You shoot the dragon with the magical crossbow and it falls dead on the ground!")

    fun spellStrategy() =
        logger.info("You cast the spell of disintegration and the dragon vaporizes in a pile of dust!")
}
```

And here's the dragonslayer in action.

```kotlin
logger.info(GREEN_DRAGON_SPOTTED)
val dragonSlayer = DragonSlayer(Strategy::meleeStrategy)
dragonSlayer.goToBattle()

logger.info(RED_DRAGON_EMERGES)
dragonSlayer.changeStrategy(Strategy::projectileStrategy)
dragonSlayer.goToBattle()

logger.info(BLACK_DRAGON_LANDS)
dragonSlayer.changeStrategy(Strategy::spellStrategy)
dragonSlayer.goToBattle()
```

The program output is the same as the above one.

## Class diagram

![alt text](etc/strategy.svg "Strategy")

## Applicability

Use the Strategy pattern when

* Many related classes differ only in their behavior. Strategies provide a way
  to configure a class either one of many behaviors
* You need different variants of an algorithm. for example, you might define
  algorithms reflecting different space/time trade-offs. Strategies can be used
  when these variants are implemented as a class hierarchy of algorithms
* An algorithm uses data that clients shouldn't know about. Use the Strategy
  pattern to avoid exposing complex algorithm-specific data structures
* A class defines many behaviors, and these appear as multiple conditional
  statements in its operations. Instead of many conditionals, move the related
  conditional branches into their own Strategy class

## Tutorial

* [Strategy Pattern Tutorial](https://www.journaldev.com/1754/strategy-design-pattern-in-java-example-tutorial)

## Credits

* [Design Patterns: Elements of Reusable Object-Oriented Software](https://www.amazon.com/gp/product/0201633612/ref=as_li_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=0201633612&linkCode=as2&tag=javadesignpat-20&linkId=675d49790ce11db99d90bde47f1aeb59)
* [Functional Programming in Java: Harnessing the Power of Java 8 Lambda Expressions](https://www.amazon.com/gp/product/1937785467/ref=as_li_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=1937785467&linkCode=as2&tag=javadesignpat-20&linkId=7e4e2fb7a141631491534255252fd08b)
* [Head First Design Patterns: A Brain-Friendly Guide](https://www.amazon.com/gp/product/0596007124/ref=as_li_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=0596007124&linkCode=as2&tag=javadesignpat-20&linkId=6b8b6eea86021af6c8e3cd3fc382cb5b)
* [Refactoring to Patterns](https://www.amazon.com/gp/product/0321213351/ref=as_li_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=0321213351&linkCode=as2&tag=javadesignpat-20&linkId=2a76fcb387234bc71b1c61150b3cc3a7)
