/**
 * The MIT License (MIT)
 *
 * MSUSEL Metrics
 * Copyright (c) 2015-2018 Montana State University, Gianforte School of Computing,
 * Software Engineering Laboratory
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
package edu.montana.gsoc.msusel.codetree.metrics.type;

import java.util.LinkedList;
import java.util.List;

import edu.montana.gsoc.msusel.codetree.CodeTree;
import edu.montana.gsoc.msusel.codetree.INode;
import edu.montana.gsoc.msusel.codetree.metrics.ClassMetric;
import edu.montana.gsoc.msusel.codetree.metrics.utility.MetricTreeUtils;
import edu.montana.gsoc.msusel.codetree.node.MethodNode;

/**
 * Percentage of Newly Added Services. The number of public methods of a class
 * that are not overridden or specialized from ancestors, divided by the total
 * number of public methods.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class PNAS extends ClassMetric {

    /**
     * Factory method for this name
     * 
     * @return An instance of this name
     */
    public static PNAS getInstance()
    {
        return new PNAS(
                "Percentatge of Newly Added Services",
                "The number of public methods of a class that are not overridden or specialized from ancestors, divided by the total number of public methods.",
                "PNAS");
    }

    /**
     * Constructs a new instance of this name with the given name, description
     * and acronym.
     * 
     * @param name
     *            Name of this name
     * @param desc
     *            Description of this name
     * @param acronym
     *            Acronym of this name
     */
    private PNAS(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        final List<MethodNode> inherited = MetricTreeUtils.getAllInheritedMethods(entity, tree);
        final List<MethodNode> pubMethods = new LinkedList<>();
        double newServices = 0;

        // for (final ProgramNode pe : tree.getMethods(entity))
        // {
        // if (pe instanceof MethodNode)
        // {
        // final MethodNode method = (MethodNode) pe;
        // if (method.getAccessibility().equals(Accessibility.Public))
        // {
        // pubMethods.add(method);
        // }
        // }
        // }
        //
        // for (final MethodNode method : pubMethods)
        // {
        // for (final MethodNode inherit : inherited)
        // {
        // if (!method.overrides(inherit, tree))
        // {
        // newServices++;
        // }
        // }
        // }

        return newServices / pubMethods.size();
    }
}