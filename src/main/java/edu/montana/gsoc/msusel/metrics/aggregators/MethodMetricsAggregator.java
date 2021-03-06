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
import edu.montana.gsoc.msusel.node.MethodNode;
import edu.montana.gsoc.msusel.node.TypeNode;

/**
 * Aggregates metrics from the method level into their containing type.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class MethodMetricsAggregator extends MetricsAggregator {

    /**
     * {@inheritDoc}
     */
    @Override
    public void aggregate(CodeTree tree)
    {
        for (TypeNode tn : tree.getUtils().getTypes())
        {
            Map<String, Double> totals = Maps.newHashMap();
            for (MethodNode mn : tn.getMethods())
            {
                metricSum(totals, mn);
            }

            for (String m : totals.keySet())
            {
                tn.addMetric(m, totals.get(m));
            }
        }
    }

}
