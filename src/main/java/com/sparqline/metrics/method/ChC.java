/**
 * The MIT License (MIT)
 *
 * SparQLine Metrics
 * Copyright (c) 2015-2017 Isaac Griffith, SparQLine Analytics, LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.sparqline.metrics.method;

import com.sparqline.codetree.CodeTree;
import com.sparqline.codetree.INode;
import com.sparqline.codetree.node.CodeNode;
import com.sparqline.metrics.MethodMetric;
import com.sparqline.metrics.annotations.MetricScope;

/**
 * Changing Classes. The number of classes in which the methods that call the
 * measured method are defined in.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class ChC extends MethodMetric {

    /**
     * Factory method for this metric
     * 
     * @return An instance of this metric
     */
    public static ChC getInstance()
    {
        return new ChC(
                "Changing Classes",
                "The number of classes in which the methods that call the measured method are defined in.", "ChC");
    }

    /**
     * Constructs a new instance of this metric with the given name, description
     * and acronym.
     * 
     * @param name
     *            Name of this metric
     * @param desc
     *            Description of this metric
     * @param acronym
     *            Acronym of this metric
     */
    private ChC(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        double chc = 0;

        /*
         * final MethodNode method = (MethodNode) entity;
         * ClassOrInterfaceNode methodOwner = (ClassOrInterfaceNode)
         * tree.getMethodOwner(method);
         * Set<ProgramNode> others = new HashSet<>();
         * others.addAll(tree.getMethods());
         * others.remove(method);
         * List<ClassOrInterfaceNode> owners = new LinkedList<>();
         * for (ProgramNode pe : others)
         * {
         * MethodNode other = (MethodNode) pe;
         * if (other.getCallOwners().contains(methodOwner))
         * owners.add((ClassOrInterfaceNode) tree.getMethodOwner(other));
         * }
         */

        return chc /* = owners.size() */;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPrerequisites()
    {
        // double CDISP = taskMap.containsKey("CDISP") ?
        // taskMap.get("CDISP").join().getValue() : entity.getMetric("DISP");
    }
}
