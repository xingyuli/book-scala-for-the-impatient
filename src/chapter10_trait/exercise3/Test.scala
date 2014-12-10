package chapter10_trait.exercise3

object Test {

  /*
      lin(BitSet)
      # trait BitSet extends SortedSet with BitSetLike
      = BitSet >> lin(BitSetLike) >> lin(SortedSet)
      
      # trait BitSetLike extends SortedSetLike
      # trait SortedSet extends Set with SortedSetLike
      = BitSet >> (BitSetLike >> lin(SortedSetLike)) >> (SortedSet >> lin(SortedSetLike) >> lin(Set))
      = BitSet >> BitSetLike >> SortedSet >> lin(SortedSetLike) >> lin(Set)
      
      # trait SortedSetLike extends Sorted with SetLike
      # trait Set extends (A => Boolean) with Iterable with GenSet with GenericSetTemplate with SetLike
      = BitSet >> BitSetLike >> SortedSet >> (SortedSetLike >> lin(SetLike) >> lin(Sorted)) >> (Set >> lin(SetLike) >> lin(GenericSetTemplate) >> lin(GenSet) >> lin(Iterable))
      = BitSet >> BitSetLike >> SortedSet >> SortedSetLike >> lin(Sorted) >> Set >> lin(SetLike) >> lin(GenericSetTemplate) >> lin(GenSet) >> lin(Iterable)
      
      # trait Sorted
      # trait SetLike extends IterableLike with GenSetLike with Subtractable with Parallelizable
      # trait GenericSetTemplate extends GenericTraversableTemplate
      # trait GenSet extends GenSetLike with GenIterable with GenericSetTemplate
      # trait Iterable extends Traversable with GenIterable with GenericTraversableTemplate with IterableLike
      
      ## remove duplicates
      ## trait Sorted
      ## trait SetLike extends Subtractable with Parallelizable
      ## trait GenSet extends GenSetLike with GenericSetTemplate
      ## trait Iterable extends Traversable with GenIterable with GenericTraversableTemplate with IterableLike
      = BitSet >> BitSetLike >> SortedSet >> SortedSetLike >> Sorted >> Set
        >> SetLike >> lin(Parallelizable) >> lin(Subtractable)
        >> GenSet >> lin(GenericSetTemplate) >> lin(GenSetLike)
        >> Iterable >> lin(IterableLike) >> lin(GenericTraversableTemplate) >> lin(GenIterable) >> lin(Traversable)
      
      # trait Parallelizable extends Any
      # trait Subtractable
      # trait GenericSetTemplate extends GenericTraversableTemplate
      # trait GenSetLike extends GenIterableLike with Equals with Parallelizable
      # trait IterableLike extends Any with Equals with TraversableLike with GenIterableLike
      # trait GenericTraversableTemplate extends HasNewBuilder
      # trait GenIterable extends GenIterableLike with GenTraversable with GenericTraversableTemplate
      # trait Traversable extends TraversableLike with GenTraversable with TraversableOnce with GenericTraversableTemplate
      
      ## remove duplicates
      ## trait Subtractable
      ## trait GenericSetTemplate
      ## trait GenSetLike with Parallelizable
      ## trait IterableLike extends Any with Equals
      ## trait GenIterable extends GenIterableLike
      ## trait Traversable extends TraversableLike with GenTraversable with TraversableOnce with GenericTraversableTemplate
  */
  
}