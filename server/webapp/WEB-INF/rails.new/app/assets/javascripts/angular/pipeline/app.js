'use strict';

angular.module('pipeline', ['angularMoment']).service('PipelineService', ['$http', function ($http) {
    return {
        getHistory: function (pipelineName) {
            //return the promise directly.
            return $http.get("/go/api/pipelines/" + pipelineName + "/history")
                .then(function (result) {
                    //resolve the promise as the data
                    return result.data;
                });
        }
    }
}]).controller('PipelineHistoryController', ['$scope', 'PipelineService', function ($scope, PipelineService) {
    $scope.heading = 'Pipeline history';

    $scope.loadHistory = function (pipelineName) {
        $scope.pipelineName = pipelineName;

        PipelineService.getHistory((pipelineName)).then(function (data) {
            $scope.data = data;
        });

    }

    $scope.isPipelinePaused = function () {
        return this.data && this.data.paused == 'true';
    }

    $scope.canPause = function () {
        return this.data && this.data.canPause == "true";
    }

    $scope.displayForceBuildButton = function () {
        return this.data && this.data.showForceBuildButton == 'true';
    }

    $scope.canForce = function () {
        return this.data && this.data.canForce == 'true'
    }

    $scope.stageStatusStyle = function(status){
        return status.toLowerCase() + "-stage"
    }

    $scope.revisionLabel = function(pipeline){
        return pipeline.build_cause.material_revisions.first().modifications.first().revision;
    }

    $scope.triggerTime = function(pipeline) {
        return pipeline.stages.first().jobs.first().scheduled_date;
    }

    $scope.triggerMessage = function(pipeline) {
        return pipeline.build_cause.trigger_forced ? pipeline.build_cause.trigger_message: "Triggered by changes";
    }
}]);