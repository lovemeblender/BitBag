# BitBag

This is a simple dynamic boolean storage. If we use a boolean array then we need to allocate 8-bit for each value stored in the array. 

However we can move to a bit level and exploit all bits (more on this later) in any Java's primitive type. A set bit would represent
a true value and a non set bit a false value.

I use an int array and each slot holds 31 boolean slots - the extra bit is to represent the negative int values and I don't currently 
make use of it.

The array is dynamic; starts with 31 bits and each time we try to set a bit exceeding the current size, the array resizes accordingly.

So, instead of 31 bytes (248 bit) we now use 31 bit. A decrease of 87.5% - best-case scenario, depending on the sparsity of the array.
