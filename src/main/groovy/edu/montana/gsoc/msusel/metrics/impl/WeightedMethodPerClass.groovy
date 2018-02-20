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
package edu.montana.gsoc.msusel.metrics.impl

import edu.montana.gsoc.msusel.codetree.node.AbstractNode
import edu.montana.gsoc.msusel.codetree.node.Modifiers
import edu.montana.gsoc.msusel.codetree.node.type.ClassNode
import edu.montana.gsoc.msusel.metrics.AbstractMetric
import edu.montana.gsoc.msusel.metrics.annotations.*

/**
 * @author Isaac Griffith
 * @version 1.2.0
 */
@MetricDefinition(
        name = "Weighted Methods per Class",
        primaryHandle = "WMC",
        description = "A weighted measure of the complexities of methods defined in a class. Uses cyclomatic complexity and normalizes the methods such that the median method has a complexity of 1.0",
        properties = @MetricProperties(
                range = "Positive Real",
                aggregation = [],
                scope = MetricScope.TYPE,
                type = MetricType.Derived,
                scale = MetricScale.Ratio,
                category = MetricCategory.Complexity
        ),
        references = [
                'Chidamber, Shyam R., and Chris F. Kemerer. Towards a metrics suite for object oriented design. Vol. 26. No. 11. ACM, 1991.',
                'Chidamber, Shyam R., and Chris F. Kemerer. "A metrics suite for object oriented design." IEEE Transactions on software engineering 20.6 (1994): 476-493.'
        ]
)
class WeightedMethodPerClass extends AbstractMetric {

    /**
     *
     */
    WeightedMethodPerClass() {
        // TODO Auto-generated constructor stub
    }

    /**
     * {@inheritDoc}
     */
    @Override
    def measure(AbstractNode node) {
        double total = 0

        if (node instanceof ClassNode) {
            def methods = node.methods().findAll { it.specifiers.contains[Modifiers.ABSTRACT] }

            def cyclo = []
            methods.each {
                cyclo << getMetric(it, "CYCLO")
            }

            double val = cyclo.sum()
            val /= cyclo.size()

            cyclo = cyclo.multiply(val)
            total = cyclo.sum()
        }

        total
    }
}