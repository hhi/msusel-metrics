/**
 * The MIT License (MIT)
 *
 * MSUSEL Metrics
 * Copyright (c) 2015-2017 Montana State University, Gianforte School of Computing,
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
package edu.montana.gsoc.msusel.metrics.aggregators;

import java.util.Map;

import com.google.common.collect.Maps;

import edu.montana.gsoc.msusel.CodeTree;
import edu.montana.gsoc.msusel.metrics.MetricsAggregator;
import edu.montana.gsoc.msusel.node.FileNode;
import edu.montana.gsoc.msusel.node.TypeNode;

/**
 * Aggregates the metrics at the Type Level up to the containing File
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class ClassMetricsAggregator extends MetricsAggregator {

    /**
     * {@inheritDoc}
     */
    @Override
    public void aggregate(CodeTree tree)
    {
        for (FileNode fn : tree.getUtils().getFiles())
        {
            Map<String, Double> totals = Maps.newHashMap();
            for (TypeNode tn : fn.getTypes())
            {
                metricSum(totals, tn);
            }

            for (String m : totals.keySet())
            {
                fn.addMetric(m, totals.get(m));
            }
        }
    }
}
