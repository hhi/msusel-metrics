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
package com.sparqline.metrics.project;

import com.sparqline.codetree.CodeTree;
import com.sparqline.codetree.INode;
import com.sparqline.metrics.ProjectMetric;

/**
 * Median Lines of Code. This metric calculates the median lines of
 * code for classes in the system.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class LOCmedian extends ProjectMetric {

    /**
     * Factory method for this metric
     * 
     * @return An instance of this metric
     */
    public static LOCmedian getInstance()
    {
        return new LOCmedian(
                "Median Lines of Code", "This metric calculates the median lines of code for classes in the system.",
                "LOC_median");
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
    private LOCmedian(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        double medianLOC = 0;
        /*
         * final List<ProgramNode> entities = tree.getClasses();
         * final List<Double> locValues = new LinkedList<>();
         * for (final ProgramNode entity : entities)
         * {
         * locValues.add(entity.getMetric("LOC"));
         * }
         * Collections.sort(locValues);
         * if ((locValues.size() % 2) == 0)
         * {
         * medianLOC = (locValues.get((locValues.size() / 2) - 1) +
         * locValues.get(locValues.size() / 2)) / 2;
         * }
         * else
         * {
         * medianLOC = (locValues.get((locValues.size() / 2) - 1));
         * }
         */

        return medianLOC;
    }

}