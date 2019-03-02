/*	$ Header: $
 *
 *	Copyright 2019 NCS Pearson, Inc. All rights reserved.
 */

package com.nakka.dspro.queue;

/**
 * @author Srikanth Nakka
 * @version $Revision: #1 $ submitted $DateTime: 2013/08/29 10:34:55 $ by $Author: clemka $
 * @since 2.3.xxxx
 */
public class FixedSizeArrayQueue {

    int array[] = null;
    int rear, front, size, capacity = 0;

    public FixedSizeArrayQueue(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.rear = (capacity - 1);
        this.front = (capacity - 1);
        this.array = new int[capacity];
    }

    public int getSize(){
        return  size;
    }


    public boolean isFull(){
        return (this.size == this.capacity);
    }

    public boolean isEmpty(){
        return (this.size == 0);
    }

    public boolean enQueue(int value){

        if(isFull())
            return false;
        else
            rear = (rear + 1) % capacity;
            array[rear] = value;
            size = size + 1;

        return true;
    }

    public int getRear(){
        return rear;
    }
    public int getFront(){
        return front;
    }

    public int deQueue(){
        int value = -1;
        if(!isEmpty()) {

            size = size - 1;
            front = (front + 1) % capacity;
            value = array[front];
        }
        return value;
    }
}
