var PlayField = React.createClass({
    getInitialState: function () {
        return {data: []};
    },
    componentDidMount: function () {
        this.connectToLobbies();
    },
    connectToLobbies: function () {
        var stompClient = null;
        var component = this;

        function connect() {
            var socket = new WebSocket('ws://' + location.host + '/test');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, connectHandle, errorHandle);
        }

        function connectHandle(frame) {
            console.log('Connected: ' + frame);
            stompClient.send("/app/lobbies/init", {}, "init");
            stompClient.subscribe('/topic/lobbies', function (data) {
                console.log(data.body);
                component.setState({data: JSON.parse(data.body)});
            });
        }

        function errorHandle(message) {
            if (stompClient != null) {
                stompClient.disconnect();
                stompClient = null;
            }
            console.log("Disconnected: " + message);
        }

        connect();
    },
    render: function () {
        var lobbies = [];
        var lobbyData = this.state.data;
        console.log(lobbyData.length);
        for (var i = 0; i < lobbyData.length; i++) {
            lobbies.push(<LobbyCard title={lobbyData[i].name} key={lobbyData[i].name}/>);
        }
        return (
            <div className="jumbotron container-fluid">
                <h2>Lobbies</h2>
                {lobbies}
            </div>
        );
    }
});

var LobbyCard = React.createClass({
    render: function () {
        var title = this.props.title;
        return (
            <div className="jumbotron">
                <h3>{title}</h3>
            </div>
        );
    }
});

ReactDOM.render(
    <PlayField />,
    document.getElementById("container")
);
