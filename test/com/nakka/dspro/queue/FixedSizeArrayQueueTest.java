/*	$ Header: $
 *
 *	Copyright 2019 NCS Pearson, Inc. All rights reserved.
 */

package com.nakka.dspro.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Srikanth Nakka
 * @version $Revision: #1 $ submitted $DateTime: 2013/08/29 10:34:55 $ by $Author: clemka $
 * @since 2.3.xxxx
 */

public class FixedSizeArrayQueueTest {


    static FixedSizeArrayQueue queue = null;

    public static void main(String[] args) {
        setup();
        testFixedSizeArrayQueueOperations();
    }

    //@Before
    private static void setup(){
        queue = new FixedSizeArrayQueue(5);
    }

    //@Test
    public static void testFixedSizeArrayQueueOperations(){
        System.out.println("Rear: " + queue.getRear() + " Front: " + queue.getFront() + " Size: " + queue.getSize());
        // insert 2 elements in queue
        assertEquals(true, queue.enQueue(10)); System.out.println("Rear: " + queue.getRear() + " Front: " + queue.getFront()+ " Size: " + queue.getSize());
        assertEquals(true, queue.enQueue(11)); System.out.println("Rear: " + queue.getRear() + " Front: " + queue.getFront()+ " Size: " + queue.getSize());

        // check size
        assertEquals(2, queue.getSize());

        // remove 1 element
        assertEquals(10, queue.deQueue()); System.out.println("Rear: " + queue.getRear() + " Front: " + queue.getFront() + " Size: " + queue.getSize());

        // insert 5 elements - overflow by one elemnet
        assertEquals(true, queue.enQueue(12)); System.out.println("Rear: " + queue.getRear() + " Front: " + queue.getFront()+ " Size: " + queue.getSize());
        assertEquals(true, queue.enQueue(13)); System.out.println("Rear: " + queue.getRear() + " Front: " + queue.getFront()+ " Size: " + queue.getSize());
        assertEquals(true, queue.enQueue(14)); System.out.println("Rear: " + queue.getRear() + " Front: " + queue.getFront()+ " Size: " + queue.getSize());
        assertEquals(true, queue.enQueue(15)); System.out.println("Rear: " + queue.getRear() + " Front: " + queue.getFront()+ " Size: " + queue.getSize());
        assertEquals(false, queue.enQueue(16)); System.out.println("Rear: " + queue.getRear() + " Front: " + queue.getFront()+ " Size: " + queue.getSize());

        // remove 6 elemetns - under flow
        assertEquals(11, queue.deQueue()); System.out.println("Rear: " + queue.getRear() + " Front: " + queue.getFront()+ " Size: " + queue.getSize());
        assertEquals(12, queue.deQueue()); System.out.println("Rear: " + queue.getRear() + " Front: " + queue.getFront()+ " Size: " + queue.getSize());
        assertEquals(13, queue.deQueue()); System.out.println("Rear: " + queue.getRear() + " Front: " + queue.getFront()+ " Size: " + queue.getSize());
        assertEquals(14, queue.deQueue()); System.out.println("Rear: " + queue.getRear() + " Front: " + queue.getFront()+ " Size: " + queue.getSize());
        assertEquals(15, queue.deQueue()); System.out.println("Rear: " + queue.getRear() + " Front: " + queue.getFront()+ " Size: " + queue.getSize());
        assertEquals(-1, queue.deQueue()); System.out.println("Rear: " + queue.getRear() + " Front: " + queue.getFront()+ " Size: " + queue.getSize());

        assertEquals(true, queue.enQueue(20)); System.out.println("Rear: " + queue.getRear() + " Front: " + queue.getFront()+ " Size: " + queue.getSize());
        assertEquals(20, queue.deQueue()); System.out.println("Rear: " + queue.getRear() + " Front: " + queue.getFront()+ " Size: " + queue.getSize());

    }



}
