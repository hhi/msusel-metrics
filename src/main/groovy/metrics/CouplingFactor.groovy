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
package metrics

import edu.montana.gsoc.msusel.codetree.node.AbstractNode
import edu.montana.gsoc.msusel.codetree.node.structural.StructuralNode
import metrics.annotations.*

/**
 * @author Isaac Griffith
 * @version 1.2.0
 */
@MetricDefinition(
        name = "Coupling Factor",
        primaryHandle = "CF",
        description = "Ratio of the number of classes a class is connected to to the number of possible class communications",
        properties = @MetricProperties(
                range = "0.0..1.0",
                aggregation = [],
                scope = MetricScope.TYPE,
                type = MetricType.Derived,
                scale = MetricScale.Interval,
                category = MetricCategory.Coupling
        ),
        references = [
                'Abreu, Fernando Brito, and Rogério Carapuça. "Object-oriented software engineering: Measuring and controlling the development process." Proceedings of the 4th international conference on software quality. Vol. 186. 1994.',
                'e Abreu, F. Brito, and Walcelio Melo. "Evaluating the impact of object-oriented design on software quality." Software Metrics Symposium, 1996., Proceedings of the 3rd International. IEEE, 1996.',
                'Abreu, F. Brito, Miguel Goulão, and Rita Esteves. "Toward the design quality evaluation of object-oriented software systems." Proceedings of the 5th International Conference on Software Quality, Austin, Texas, USA. 1995.'
        ]
)
class CouplingFactor extends AbstractMetric {

    /**
     *
     */
    CouplingFactor() {
        // TODO Auto-generated constructor stub
    }

    /**
     * {@inheritDoc}
     */
    @Override
    def measure(AbstractNode node) {
        int total = 0.0

        if (node instanceof StructuralNode) {
            Set classes = node.classes()

            int size = 0
            classes.each {
                Set coupled = []
                coupled += tree.getAssociatedFrom(it)
                coupled += tree.getUseFrom(it)
                coupled += tree.getDependencyFrom(it)
                coupled += tree.getAggregatedFrom(it)
                coupled += tree.getComposedFrom(it)

                size += coupled.intersect(classes).size()
            }

            total = size / (0.5 * (int) Math.pow(classes.size(), 2) - classes.size())
        }

        total
    }

}