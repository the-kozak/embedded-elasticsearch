package pl.allegro.tech.embeddedelasticsearch

import static java.util.concurrent.TimeUnit.MINUTES
import static pl.allegro.tech.embeddedelasticsearch.EmbeddedElasticConfiguration.START_TIMEOUT_IN_MINUTES
import static pl.allegro.tech.embeddedelasticsearch.EmbeddedElasticConfiguration.TEST_ES_JAVA_OPTS

class PluginsInstallationSpec extends PluginsInstallationBaseSpec {

    static final HTTP_PORT_VALUE = 9200

    EmbeddedElastic.Builder baseEmbeddedElastic() {
        return EmbeddedElastic.builder()
                .withElasticVersion("5.0.0")
                .withEsJavaOpts(TEST_ES_JAVA_OPTS)
                .withStartTimeout(START_TIMEOUT_IN_MINUTES, MINUTES)
                .withSetting(PopularProperties.HTTP_PORT, HTTP_PORT_VALUE)
    }

    @Override
    String pluginByUrlUrl() {
        return "https://artifacts.elastic.co/downloads/elasticsearch-plugins/analysis-stempel/analysis-stempel-5.0.0.zip"
    }

    @Override
    String pluginByUrlName() {
        return "analysis-stempel"
    }

    @Override
    String pluginByName() {
        return "discovery-file"
    }
}
